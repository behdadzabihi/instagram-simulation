package krd.kurdistan.bootcamp.following;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-01T23:52:39-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class FollowingMapperImpl implements FollowingMapper {

    @Autowired
    private UserAppMapper userAppMapper;

    @Override
    public Following toFollowing(FollowingDTO followingDTO) {
        if ( followingDTO == null ) {
            return null;
        }

        Following following = new Following();

        following.setId( followingDTO.getId() );
        following.setVersion( followingDTO.getVersion() );
        following.setCreatedData( followingDTO.getCreatedData() );
        following.setCreatedBy( followingDTO.getCreatedBy() );
        following.setLastModifiedData( followingDTO.getLastModifiedData() );
        following.setLastModifiedBy( followingDTO.getLastModifiedBy() );
        following.setUserName( followingDTO.getUserName() );
        following.setProfileImage( followingDTO.getProfileImage() );
        following.setRemoveFromFallowingList( followingDTO.getRemoveFromFallowingList() );
        following.setUserApp( userAppMapper.toUserApp( followingDTO.getUserApp() ) );

        return following;
    }

    @Override
    public FollowingDTO toFollowingDTO(Following following) {
        if ( following == null ) {
            return null;
        }

        FollowingDTO followingDTO = new FollowingDTO();

        followingDTO.setId( following.getId() );
        followingDTO.setVersion( following.getVersion() );
        followingDTO.setCreatedData( following.getCreatedData() );
        followingDTO.setCreatedBy( following.getCreatedBy() );
        followingDTO.setLastModifiedData( following.getLastModifiedData() );
        followingDTO.setLastModifiedBy( following.getLastModifiedBy() );
        followingDTO.setUserName( following.getUserName() );
        followingDTO.setProfileImage( following.getProfileImage() );
        followingDTO.setRemoveFromFallowingList( following.getRemoveFromFallowingList() );
        followingDTO.setUserApp( userAppMapper.toUserAppDTO( following.getUserApp() ) );

        return followingDTO;
    }

    @Override
    public List<Following> toFollowings(List<FollowingDTO> followingDTOS) {
        if ( followingDTOS == null ) {
            return null;
        }

        List<Following> list = new ArrayList<Following>( followingDTOS.size() );
        for ( FollowingDTO followingDTO : followingDTOS ) {
            list.add( toFollowing( followingDTO ) );
        }

        return list;
    }

    @Override
    public List<FollowingDTO> toFollowingDTOS(List<Following> followings) {
        if ( followings == null ) {
            return null;
        }

        List<FollowingDTO> list = new ArrayList<FollowingDTO>( followings.size() );
        for ( Following following : followings ) {
            list.add( toFollowingDTO( following ) );
        }

        return list;
    }
}
