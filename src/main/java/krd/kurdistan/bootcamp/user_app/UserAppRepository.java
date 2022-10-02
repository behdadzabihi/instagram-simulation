package krd.kurdistan.bootcamp.user_app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAppRepository  extends PagingAndSortingRepository<UserApp,Long> {

    Page<UserApp> findAll(Pageable pageable);
}
