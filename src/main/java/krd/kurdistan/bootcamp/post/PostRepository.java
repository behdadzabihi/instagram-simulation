package krd.kurdistan.bootcamp.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {

    Page<Post> findAll(Pageable pageable);
}
