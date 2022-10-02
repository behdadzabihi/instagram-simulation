package krd.kurdistan.bootcamp.user_app;

import org.springframework.data.domain.Page;

public interface UserAppService {

    UserApp save(UserApp userApp);

    UserApp update(UserApp userApp);

    void delete(Long id);

    Page<UserApp> findAll(Integer page,Integer size);

    UserApp findById(Long id);
}
