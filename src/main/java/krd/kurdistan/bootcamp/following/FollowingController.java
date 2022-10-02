package krd.kurdistan.bootcamp.following;

import krd.kurdistan.bootcamp.common.PagingData;
import krd.kurdistan.bootcamp.follower.Follower;
import krd.kurdistan.bootcamp.follower.FollowerDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/following/")
@AllArgsConstructor
public class FollowingController {

    private final FollowingService service;

    private final FollowingMapper mapper;

    @PostMapping("v1")
    public ResponseEntity<FollowingDTO> save(@RequestBody FollowingDTO followingDTO){
        Following following=mapper.toFollowing(followingDTO);
        service.save(following);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<FollowingDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Following> followingPage=service.findAll(page,size);
        int total=followingPage.getTotalPages();
        List<Following> followings=followingPage.getContent();
        List<FollowingDTO> followingDTOS=mapper.toFollowingDTOS(followings);
        PagingData<FollowingDTO> followingDTOPagingData=new PagingData<>(total,page,followingDTOS);
        return ResponseEntity.ok(followingDTOPagingData);
    }


    @GetMapping("/v1/filter-by-user/{page}/{size}/{userAppId}")
    public ResponseEntity<PagingData<FollowingDTO>> getByUsers(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long userAppId){
        Page<Following> followingPage=service.findByUserApp(page,size,userAppId);
        int total=followingPage.getTotalPages();
        List<Following> followings=followingPage.getContent();
        List<FollowingDTO> followingDTOS=mapper.toFollowingDTOS(followings);
        PagingData<FollowingDTO> followingDTOPagingData=new PagingData<>(total,page,followingDTOS);
        return ResponseEntity.ok(followingDTOPagingData);
    }

    @DeleteMapping("v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("v1")
    public ResponseEntity<FollowingDTO> update(@RequestBody FollowingDTO followingDTO){
        Following following=mapper.toFollowing(followingDTO);
        service.update(following);
        return ResponseEntity.ok(followingDTO);
    }

    @GetMapping("v1/{id}")
    public ResponseEntity<FollowingDTO> findById(@PathVariable Long id){
        Following following= service.findById(id);
        FollowingDTO followingDTO=mapper.toFollowingDTO(following);
        return ResponseEntity.ok(followingDTO);
    }
}
