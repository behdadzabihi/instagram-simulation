package krd.kurdistan.bootcamp.like;

import krd.kurdistan.bootcamp.post.PostMapper;
import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserAppMapper.class, PostMapper.class})

public interface LikeMapper {


    Like toLike(LikeDTO likeDTO);

    LikeDTO toLikeDTO(Like like);

    List<Like> toLikes(List<LikeDTO> likeDTOS);

    List<LikeDTO> toLikeDTOS(List<Like> likes);

}
