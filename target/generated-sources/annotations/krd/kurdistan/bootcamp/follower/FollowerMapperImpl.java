package krd.kurdistan.bootcamp.follower;

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
public class FollowerMapperImpl implements FollowerMapper {

    @Autowired
    private UserAppMapper userAppMapper;

    @Override
    public Follower toFollower(FollowerDTO followerDTO) {
        if ( followerDTO == null ) {
            return null;
        }

        Follower follower = new Follower();

        follower.setId( followerDTO.getId() );
        follower.setVersion( followerDTO.getVersion() );
        follower.setCreatedData( followerDTO.getCreatedData() );
        follower.setCreatedBy( followerDTO.getCreatedBy() );
        follower.setLastModifiedData( followerDTO.getLastModifiedData() );
        follower.setLastModifiedBy( followerDTO.getLastModifiedBy() );
        follower.setUserName( followerDTO.getUserName() );
        follower.setProfileImage( followerDTO.getProfileImage() );
        follower.setIsFollower( followerDTO.getIsFollower() );
        follower.setUserApp( userAppMapper.toUserApp( followerDTO.getUserApp() ) );

        return follower;
    }

    @Override
    public FollowerDTO toFollowerDTO(Follower follower) {
        if ( follower == null ) {
            return null;
        }

        FollowerDTO followerDTO = new FollowerDTO();

        followerDTO.setId( follower.getId() );
        followerDTO.setVersion( follower.getVersion() );
        followerDTO.setCreatedData( follower.getCreatedData() );
        followerDTO.setCreatedBy( follower.getCreatedBy() );
        followerDTO.setLastModifiedData( follower.getLastModifiedData() );
        followerDTO.setLastModifiedBy( follower.getLastModifiedBy() );
        followerDTO.setUserName( follower.getUserName() );
        followerDTO.setProfileImage( follower.getProfileImage() );
        followerDTO.setIsFollower( follower.getIsFollower() );
        followerDTO.setUserApp( userAppMapper.toUserAppDTO( follower.getUserApp() ) );

        return followerDTO;
    }

    @Override
    public List<Follower> toFollowers(List<FollowerDTO> followerDTOS) {
        if ( followerDTOS == null ) {
            return null;
        }

        List<Follower> list = new ArrayList<Follower>( followerDTOS.size() );
        for ( FollowerDTO followerDTO : followerDTOS ) {
            list.add( toFollower( followerDTO ) );
        }

        return list;
    }

    @Override
    public List<FollowerDTO> toFollowerDTOS(List<Follower> followers) {
        if ( followers == null ) {
            return null;
        }

        List<FollowerDTO> list = new ArrayList<FollowerDTO>( followers.size() );
        for ( Follower follower : followers ) {
            list.add( toFollowerDTO( follower ) );
        }

        return list;
    }
}
