package krd.kurdistan.bootcamp.follower;

import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserAppMapper.class})
public interface FollowerMapper {

    Follower toFollower(FollowerDTO followerDTO);

    FollowerDTO toFollowerDTO (Follower follower);

    List<Follower> toFollowers(List<FollowerDTO> followerDTOS);

    List<FollowerDTO> toFollowerDTOS (List<Follower> followers);
}
