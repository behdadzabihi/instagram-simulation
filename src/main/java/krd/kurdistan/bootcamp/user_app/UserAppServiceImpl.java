package krd.kurdistan.bootcamp.user_app;

import krd.kurdistan.bootcamp.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAppServiceImpl implements UserAppService{

    private final UserAppRepository repository;

    @Override
    public UserApp save(UserApp userApp) {
        return repository.save(userApp);
    }

    @Override
    public UserApp update(UserApp userApp) {
       UserApp lastUser=findById(userApp.getId());
       lastUser.setFirstName(userApp.getFirstName());
       lastUser.setLastName(userApp.getLastName());
       lastUser.setEmail(userApp.getEmail());
       lastUser.setPhoneNumber(userApp.getPhoneNumber());
       lastUser.setUserName(userApp.getUserName());
       lastUser.setPassword(userApp.getPassword());
       lastUser.setBio(userApp.getBio());
       lastUser.setProfileImage(userApp.getProfileImage());
       lastUser.setPostCount(userApp.getPostCount());
       lastUser.setFollowerCount(userApp.getFollowerCount());
       lastUser.setFollowingCount(userApp.getFollowingCount());
        return repository.save(lastUser);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<UserApp> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public UserApp findById(Long id) {
        Optional<UserApp> userAppOptional=repository.findById(id);
        if(!userAppOptional.isPresent()){
            throw new NotFoundException("Not Found User");
        }
        return userAppOptional.get();
    }
}
