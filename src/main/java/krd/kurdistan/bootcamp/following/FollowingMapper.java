package krd.kurdistan.bootcamp.following;

import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserAppMapper.class})
public interface FollowingMapper {

    Following toFollowing(FollowingDTO followingDTO);

    FollowingDTO toFollowingDTO (Following following);

    List<Following> toFollowings(List<FollowingDTO> followingDTOS);

    List<FollowingDTO> toFollowingDTOS (List<Following> followings);
}
