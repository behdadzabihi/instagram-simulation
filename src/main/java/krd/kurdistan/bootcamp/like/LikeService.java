package krd.kurdistan.bootcamp.like;

import org.springframework.data.domain.Page;

import java.util.List;

public interface LikeService {

    Like save(Like like);

    Like update(Like like);

    void delete(Long id);

    Page<Like> getAll(Integer page,Integer size);

    Page<Like> findByPost(Integer page,Integer size,Long postId);

    Page<Like> findByUserApp(Integer page,Integer size,Long userAppId);

    Like findById(Long id);
}
