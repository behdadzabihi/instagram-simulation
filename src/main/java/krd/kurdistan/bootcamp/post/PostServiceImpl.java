package krd.kurdistan.bootcamp.post;

import krd.kurdistan.bootcamp.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository repository;


    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public Post update(Post post) {
        Post lastPost=findById(post.getId());
        lastPost.setTitle(post.getTitle());
        lastPost.setPostLink(post.getPostLink());
        lastPost.setDescription(post.getDescription());
        return repository.save(lastPost);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Page<Post> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Post findById(Long id) {
        Optional<Post> postOptional=repository.findById(id);
        if(!postOptional.isPresent()){
            throw new NotFoundException("Not Found User");
        }
        return postOptional.get();
    }
}
