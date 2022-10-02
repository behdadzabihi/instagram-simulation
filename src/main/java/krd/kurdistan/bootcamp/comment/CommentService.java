package krd.kurdistan.bootcamp.comment;


import org.springframework.data.domain.Page;

public interface CommentService {

    Comment save(Comment comment);

    Comment update(Comment comment);

    void delete(Long id);

    Page<Comment> findByUserApp(Integer page, Integer size, Long userAppId);

    Page<Comment> findByPost(Integer page, Integer size, Long postId);

    Comment findById(Long id);

    Page<Comment> findAll(Integer page,Integer size);
}
