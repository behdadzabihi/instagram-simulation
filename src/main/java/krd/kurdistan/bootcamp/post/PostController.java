package krd.kurdistan.bootcamp.post;


import krd.kurdistan.bootcamp.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/post/")
@AllArgsConstructor
public class PostController {

    private final PostService service;
    private final PostMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO postDTO){
        Post post=mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO){
        Post post=mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.ok(postDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id){
        Post post=service.findById(id);
        PostDTO postDTO=mapper.toPostDTO(post);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<PostDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Post> postPage=service.findAll(page,size);
        int total=postPage.getTotalPages();
        List<Post> posts=postPage.getContent();
        List<PostDTO> postDTOS=mapper.toPostDTOS(posts);
        PagingData<PostDTO> postDTOPagingData=new PagingData<>(total,page,postDTOS);
        return ResponseEntity.ok(postDTOPagingData);
    }
}
