package krd.kurdistan.bootcamp.following;

import krd.kurdistan.bootcamp.follower.Follower;
import org.springframework.data.domain.Page;

public interface FollowingService {

    Following save(Following following);

    Following update(Following following);

    void delete(Long id);

    Page<Following> findAll(Integer page, Integer size);

    Page<Following> findByUserApp(Integer page,Integer size,Long userAppId);

    Following findById(Long id);
}
