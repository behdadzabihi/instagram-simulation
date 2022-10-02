package krd.kurdistan.bootcamp.follower;

import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Registered
public interface FollowerRepository extends PagingAndSortingRepository<Follower,Long> {

    Page<Follower> findAllByUserApp_Id(Pageable pageable, Long userAppId);

    Page<Follower> findAll(Pageable pageable);
}
