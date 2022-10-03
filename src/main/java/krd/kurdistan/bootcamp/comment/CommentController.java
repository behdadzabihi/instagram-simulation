package krd.kurdistan.bootcamp.comment;


import krd.kurdistan.bootcamp.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment/")
@AllArgsConstructor
public class CommentController {

    private final CommentService service;

    private final CommentMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<CommentDTO> save(@RequestBody CommentDTO commentDTO){
        Comment comment=mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("vi/{page}/{size}")
    public ResponseEntity<PagingData<CommentDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Comment> commentPage=service.findAll(page,size);
        int total=commentPage.getTotalPages();
        List<Comment> comments=commentPage.getContent();
        List<CommentDTO> commentDTOS=mapper.toCommentDTOS(comments);
        PagingData<CommentDTO> commentDTOPagingData=new PagingData<>(total,page,commentDTOS);
        return ResponseEntity.ok(commentDTOPagingData);
    }



    @GetMapping("vi/filter-by-place/{page}/{size}/{postId}")
    public ResponseEntity<PagingData<CommentDTO>> getByPost(@PathVariable Integer page, @PathVariable Integer size, @PathVariable Long postId){
        Page<Comment> commentPage=service.findByPost(page,size,postId);
        int total=commentPage.getTotalPages();
        List<Comment> comments=commentPage.getContent();
        List<CommentDTO> commentDTOS=mapper.toCommentDTOS(comments);
        PagingData<CommentDTO> commentDTOPagingData=new PagingData<>(total,page,commentDTOS);
        return ResponseEntity.ok(commentDTOPagingData);
    }



    @DeleteMapping("v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CommentDTO> update(@RequestBody CommentDTO commentDTO){
        Comment comment=mapper.toComment(commentDTO);
        service.update(comment);
        return ResponseEntity.ok(commentDTO);
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable Long id){
       Comment comment= service.findById(id);
       CommentDTO commentDTO=mapper.toCommentDTO(comment);
       return ResponseEntity.ok(commentDTO);
    }

    @GetMapping("/v1/filter-by-user/{page}/{size}/{userAppId}")
    public ResponseEntity<PagingData<CommentDTO>> getByUserApp(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long userAppId){
        Page<Comment> commentPage=service.findByUserApp(page,size,userAppId);
        int total=commentPage.getTotalPages();
        List<Comment> comments=commentPage.getContent();
        List<CommentDTO> commentDTOS=mapper.toCommentDTOS(comments);
        PagingData<CommentDTO> commentDTOPagingData=new PagingData<>(total,page,commentDTOS);
        return ResponseEntity.ok(commentDTOPagingData);

    }
}
