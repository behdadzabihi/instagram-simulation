package krd.kurdistan.bootcamp.follower;


import org.springframework.data.domain.Page;

public interface FollowerService {

    Follower save(Follower follower);

    Follower update(Follower follower);

    void delete(Long id);

    Page<Follower> findAll(Integer page, Integer size);

    Page<Follower> findByUserApp(Integer page,Integer size,Long userAppId);

    Follower findById(Long id);
}
