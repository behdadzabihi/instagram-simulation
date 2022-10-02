package krd.kurdistan.bootcamp.post;

import krd.kurdistan.bootcamp.user_app.UserApp;
import org.springframework.data.domain.Page;

public interface PostService {

    Post save(Post post);

    Post update(Post post);

    void delete(Long id);

    Page<Post> findAll(Integer page, Integer size);

    Post findById(Long id);
}
