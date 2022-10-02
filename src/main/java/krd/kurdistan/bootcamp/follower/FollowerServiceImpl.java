package krd.kurdistan.bootcamp.follower;

import krd.kurdistan.bootcamp.common.exception.NotFoundException;
import krd.kurdistan.bootcamp.like.Like;
import krd.kurdistan.bootcamp.user_app.UserApp;
import krd.kurdistan.bootcamp.user_app.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FollowerServiceImpl implements FollowerService{

    private final FollowerRepository repository;

    private final UserAppService userAppService;



    @Override
    public Follower save(Follower follower) {
        Long userId=follower.getUserApp().getId();
        UserApp userApp=userAppService.findById(userId);
        follower.setUserApp(userApp);
        return repository.save(follower);
    }

    @Override
    public Follower update(Follower follower) {
        Follower lastFollower= findById(follower.getId());
        lastFollower.setUserName(follower.getUserName());
        lastFollower.setIsFollower(follower.getIsFollower());
        lastFollower.setProfileImage(follower.getProfileImage());
        Long userId=follower.getUserApp().getId();
        UserApp userApp=userAppService.findById(userId);
        follower.setUserApp(userApp);
        return repository.save(lastFollower);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Follower> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }



    @Override
    public Page<Follower> findByUserApp(Integer page, Integer size, Long userAppId) {
        return repository.findAllByUserApp_Id(PageRequest.of(page,size),userAppId);
    }


    @Override
    public Follower findById(Long id) {
        Optional<Follower> followerOptional=repository.findById(id);
        if(!followerOptional.isPresent()){
            throw new NotFoundException("NOT FOUND Follower");
        }
        return followerOptional.get();
    }
}
