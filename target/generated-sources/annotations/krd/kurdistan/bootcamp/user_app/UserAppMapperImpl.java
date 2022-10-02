package krd.kurdistan.bootcamp.user_app;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-01T23:52:39-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class UserAppMapperImpl implements UserAppMapper {

    @Override
    public UserApp toUserApp(UserAppDTO userAppDTO) {
        if ( userAppDTO == null ) {
            return null;
        }

        UserApp userApp = new UserApp();

        userApp.setId( userAppDTO.getId() );
        userApp.setVersion( userAppDTO.getVersion() );
        userApp.setCreatedData( userAppDTO.getCreatedData() );
        userApp.setCreatedBy( userAppDTO.getCreatedBy() );
        userApp.setLastModifiedData( userAppDTO.getLastModifiedData() );
        userApp.setLastModifiedBy( userAppDTO.getLastModifiedBy() );
        userApp.setFirstName( userAppDTO.getFirstName() );
        userApp.setLastName( userAppDTO.getLastName() );
        userApp.setPhoneNumber( userAppDTO.getPhoneNumber() );
        userApp.setEmail( userAppDTO.getEmail() );
        userApp.setUserName( userAppDTO.getUserName() );
        userApp.setPassword( userAppDTO.getPassword() );
        userApp.setProfileImage( userAppDTO.getProfileImage() );
        userApp.setBio( userAppDTO.getBio() );
        userApp.setPostCount( userAppDTO.getPostCount() );
        userApp.setFollowerCount( userAppDTO.getFollowerCount() );
        userApp.setFollowingCount( userAppDTO.getFollowingCount() );

        return userApp;
    }

    @Override
    public UserAppDTO toUserAppDTO(UserApp userApp) {
        if ( userApp == null ) {
            return null;
        }

        UserAppDTO userAppDTO = new UserAppDTO();

        userAppDTO.setId( userApp.getId() );
        userAppDTO.setVersion( userApp.getVersion() );
        userAppDTO.setCreatedData( userApp.getCreatedData() );
        userAppDTO.setCreatedBy( userApp.getCreatedBy() );
        userAppDTO.setLastModifiedData( userApp.getLastModifiedData() );
        userAppDTO.setLastModifiedBy( userApp.getLastModifiedBy() );
        userAppDTO.setFirstName( userApp.getFirstName() );
        userAppDTO.setLastName( userApp.getLastName() );
        userAppDTO.setPhoneNumber( userApp.getPhoneNumber() );
        userAppDTO.setEmail( userApp.getEmail() );
        userAppDTO.setUserName( userApp.getUserName() );
        userAppDTO.setPassword( userApp.getPassword() );
        userAppDTO.setProfileImage( userApp.getProfileImage() );
        userAppDTO.setBio( userApp.getBio() );
        userAppDTO.setPostCount( userApp.getPostCount() );
        userAppDTO.setFollowerCount( userApp.getFollowerCount() );
        userAppDTO.setFollowingCount( userApp.getFollowingCount() );

        return userAppDTO;
    }

    @Override
    public List<UserApp> toUserApps(List<UserAppDTO> userAppDTOS) {
        if ( userAppDTOS == null ) {
            return null;
        }

        List<UserApp> list = new ArrayList<UserApp>( userAppDTOS.size() );
        for ( UserAppDTO userAppDTO : userAppDTOS ) {
            list.add( toUserApp( userAppDTO ) );
        }

        return list;
    }

    @Override
    public List<UserAppDTO> toUserAppDTOS(List<UserApp> userApps) {
        if ( userApps == null ) {
            return null;
        }

        List<UserAppDTO> list = new ArrayList<UserAppDTO>( userApps.size() );
        for ( UserApp userApp : userApps ) {
            list.add( toUserAppDTO( userApp ) );
        }

        return list;
    }
}
