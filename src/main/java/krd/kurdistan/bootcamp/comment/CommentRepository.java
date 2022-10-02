package krd.kurdistan.bootcamp.comment;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment,Long> {

    Page<Comment> findAllByUserApp_Id(Pageable pageable,Long userId);
    Page<Comment> findAllByPost_Id(Pageable pageable,Long postId);

    Page<Comment> findAll(Pageable pageable);


}
