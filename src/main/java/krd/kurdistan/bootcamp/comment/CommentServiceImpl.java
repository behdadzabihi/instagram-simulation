package krd.kurdistan.bootcamp.comment;


import krd.kurdistan.bootcamp.common.exception.NotFoundException;
import krd.kurdistan.bootcamp.post.Post;
import krd.kurdistan.bootcamp.post.PostService;
import krd.kurdistan.bootcamp.user_app.UserApp;
import krd.kurdistan.bootcamp.user_app.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;

    private UserAppService userAppService;

    private PostService postService;

    @Override
    public Comment save(Comment comment) {
        Long userId=comment.getUserApp().getId();
        Long postId=comment.getPost().getId();
        UserApp userApp=userAppService.findById(userId);
        Post post=postService.findById(postId);
        comment.setUserApp(userApp);
        comment.setPost(post);
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
       Comment lastComment= findById(comment.getId());
        lastComment.setDate(comment.getDate());
        lastComment.setMessage(comment.getMessage());
        Long userId=comment.getUserApp().getId();
        Long postId=comment.getPost().getId();
        UserApp userApp=userAppService.findById(userId);
        Post post=postService.findById(postId);
        lastComment.setPost(post);
        lastComment.setUserApp(userApp);
        return repository.save(lastComment);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Comment> findByPost(Integer page, Integer size, Long postId) {
        return repository.findAllByPost_Id(PageRequest.of(page,size),postId);
    }

    @Override
    public Page<Comment> findByUserApp(Integer page, Integer size, Long userAppId) {
        return repository.findAllByUserApp_Id(PageRequest.of(page,size),userAppId);
    }


    @Override
    public Comment findById(Long id) {
        Optional<Comment> commentOptional=repository.findById(id);
        if(!commentOptional.isPresent()){
            throw new NotFoundException("NOT FOUND COMMENT");
        }
        return commentOptional.get();
    }

    @Override
    public Page<Comment> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }
}
