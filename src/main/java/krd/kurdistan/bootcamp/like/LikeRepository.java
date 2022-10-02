package krd.kurdistan.bootcamp.like;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends PagingAndSortingRepository<Like,Long> {

    Page<Like> findAllByUserApp_Id(Pageable pageable,Long userAppId);
    Page<Like> findAllByPost_Id(Pageable pageable,Long postId);

    Page<Like> findAll(Pageable pageable);


}
