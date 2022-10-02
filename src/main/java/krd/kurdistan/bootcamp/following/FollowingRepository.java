package krd.kurdistan.bootcamp.following;

import krd.kurdistan.bootcamp.follower.Follower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends PagingAndSortingRepository<Following,Long> {

    Page<Following> findAllByUserApp_Id(Pageable pageable, Long userAppId);

    Page<Following> findAll(Pageable pageable);
}
