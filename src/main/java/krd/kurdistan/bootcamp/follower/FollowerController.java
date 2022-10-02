package krd.kurdistan.bootcamp.follower;

import krd.kurdistan.bootcamp.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/follower/")
@AllArgsConstructor
public class FollowerController {

    private final FollowerService service;

    private final FollowerMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<FollowerDTO> save(@RequestBody FollowerDTO followerDTO){
        Follower follower=mapper.toFollower(followerDTO);
        service.save(follower);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<FollowerDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Follower> followerPage=service.findAll(page,size);
        int total=followerPage.getTotalPages();
        List<Follower> followers=followerPage.getContent();
        List<FollowerDTO> followerDTOS=mapper.toFollowerDTOS(followers);
        PagingData<FollowerDTO> followerDTOPagingData=new PagingData<>(total,page,followerDTOS);
        return ResponseEntity.ok(followerDTOPagingData);
    }


    @GetMapping("/v1/filter-by-user/{page}/{size}/{userAppId}")
    public ResponseEntity<PagingData<FollowerDTO>> getByUsers(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long userAppId){
        Page<Follower> followerPage=service.findByUserApp(page,size,userAppId);
        int total=followerPage.getTotalPages();
        List<Follower> followers=followerPage.getContent();
        List<FollowerDTO> followerDTOS=mapper.toFollowerDTOS(followers);
        PagingData<FollowerDTO> followerDTOPagingData=new PagingData<>(total,page,followerDTOS);
        return ResponseEntity.ok(followerDTOPagingData);
    }

    @DeleteMapping("v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("v1")
    public ResponseEntity<FollowerDTO> update(@RequestBody FollowerDTO followerDTO){
        Follower follower=mapper.toFollower(followerDTO);
        service.update(follower);
        return ResponseEntity.ok(followerDTO);
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<FollowerDTO> findById(@PathVariable Long id){
        Follower follower= service.findById(id);
        FollowerDTO followerDTO=mapper.toFollowerDTO(follower);
        return ResponseEntity.ok(followerDTO);
    }
}
