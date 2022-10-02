package krd.kurdistan.bootcamp.like;


import krd.kurdistan.bootcamp.common.exception.NotFoundException;
import krd.kurdistan.bootcamp.post.Post;
import krd.kurdistan.bootcamp.post.PostService;
import krd.kurdistan.bootcamp.user_app.UserApp;
import krd.kurdistan.bootcamp.user_app.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository repository;

    private final UserAppService userAppService;

    private final PostService postService;


    @Override
    public Like save(Like like) {
        Long userId=like.getUserApp().getId();
        Long plcId=like.getPost().getId();
        UserApp userApp=userAppService.findById(userId);
        Post post=postService.findById(plcId);
        like.setUserApp(userApp);
        like.setPost(post);
        return repository.save(like);
    }

    @Override
    public Like update(Like like) {
        Like lastLike= findById(like.getId());
        lastLike.setIsFavorite(like.getIsFavorite());
        return repository.save(lastLike);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Like> getAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<Like> findByPost(Integer page, Integer size, Long postId) {
        return repository.findAllByPost_Id(PageRequest.of(page,size),postId);
    }

    @Override
    public Page<Like> findByUserApp(Integer page, Integer size, Long userAppId) {
        return repository.findAllByUserApp_Id(PageRequest.of(page,size),userAppId);
    }


    @Override
    public Like findById(Long id) {
        Optional<Like> likeOptional=repository.findById(id);
        if(!likeOptional.isPresent()){
            throw new NotFoundException("NOT FOUND LIKE");
        }
        return likeOptional.get();
    }
}
