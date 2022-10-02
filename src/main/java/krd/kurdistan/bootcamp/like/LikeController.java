package krd.kurdistan.bootcamp.like;

import krd.kurdistan.bootcamp.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/like/")
@AllArgsConstructor
public class LikeController {

    private final LikeService service;

    private final LikeMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<LikeDTO> save(@RequestBody LikeDTO likeDTO){
        Like like=mapper.toLike(likeDTO);
        service.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<LikeDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Like> likePage=service.getAll(page,size);
        int total=likePage.getTotalPages();
        List<Like> likes=likePage.getContent();
        List<LikeDTO> likeDTOS=mapper.toLikeDTOS(likes);
        PagingData<LikeDTO> likeDTOPagingData=new PagingData<>(total,page,likeDTOS);
        return ResponseEntity.ok(likeDTOPagingData);
    }

    @GetMapping("vi/filter-by-place/{page}/{size}/{postId}")
    public ResponseEntity<PagingData<LikeDTO>> findByPost(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long postId){
        Page<Like> likePage=service.findByPost(page,size,postId);
        int total=likePage.getTotalPages();
        List<Like> likes=likePage.getContent();
        List<LikeDTO> likeDTOS=mapper.toLikeDTOS(likes);
        PagingData<LikeDTO> likeDTOPagingData=new PagingData<>(total,page,likeDTOS);
        return ResponseEntity.ok(likeDTOPagingData);
    }

    @GetMapping("/v1/filter-by-user/{page}/{size}/{userAppId}")
    public ResponseEntity<PagingData<LikeDTO>> getByUsers(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long userAppId){
        Page<Like> likePage=service.findByUserApp(page,size,userAppId);
        int total=likePage.getTotalPages();
        List<Like> likes=likePage.getContent();
        List<LikeDTO> likeDTOS=mapper.toLikeDTOS(likes);
        PagingData<LikeDTO> likeDTOPagingData=new PagingData<>(total,page,likeDTOS);
        return ResponseEntity.ok(likeDTOPagingData);
    }

    @DeleteMapping("v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<LikeDTO> update(@RequestBody LikeDTO likeDTO){
        Like like=mapper.toLike(likeDTO);
        service.update(like);
        return ResponseEntity.ok(likeDTO);
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<LikeDTO> findById(@PathVariable Long id){
       Like like= service.findById(id);
       LikeDTO likeDTO=mapper.toLikeDTO(like);
       return ResponseEntity.ok(likeDTO);
    }
}
