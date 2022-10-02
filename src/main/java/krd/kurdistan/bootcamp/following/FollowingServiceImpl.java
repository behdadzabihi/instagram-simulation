package krd.kurdistan.bootcamp.following;

import krd.kurdistan.bootcamp.common.exception.NotFoundException;
import krd.kurdistan.bootcamp.user_app.UserApp;
import krd.kurdistan.bootcamp.user_app.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FollowingServiceImpl implements FollowingService {

    private final FollowingRepository repository;

    private final UserAppService userAppService;



    @Override
    public Following save(Following following) {
        Long userId=following.getUserApp().getId();
        UserApp userApp=userAppService.findById(userId);
        following.setUserApp(userApp);
        return repository.save(following);
    }

    @Override
    public Following update(Following following) {
        Following lastFollowing= findById(following.getId());
        lastFollowing.setUserName(following.getUserName());
        lastFollowing.setRemoveFromFallowingList(following.getRemoveFromFallowingList());
        lastFollowing.setProfileImage(following.getProfileImage());
        Long userId=following.getUserApp().getId();
        UserApp userApp=userAppService.findById(userId);
        following.setUserApp(userApp);
        return repository.save(lastFollowing);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Following> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }



    @Override
    public Page<Following> findByUserApp(Integer page, Integer size, Long userAppId) {
        return repository.findAllByUserApp_Id(PageRequest.of(page,size),userAppId);
    }


    @Override
    public Following findById(Long id) {
        Optional<Following> followingOptional=repository.findById(id);
        if(!followingOptional.isPresent()){
            throw new NotFoundException("NOT FOUND Follower");
        }
        return followingOptional.get();
    }
}
