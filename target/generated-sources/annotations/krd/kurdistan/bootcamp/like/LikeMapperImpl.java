package krd.kurdistan.bootcamp.like;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.kurdistan.bootcamp.post.PostMapper;
import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T02:13:39-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class LikeMapperImpl implements LikeMapper {

    @Autowired
    private UserAppMapper userAppMapper;
    @Autowired
    private PostMapper postMapper;

    @Override
    public Like toLike(LikeDTO likeDTO) {
        if ( likeDTO == null ) {
            return null;
        }

        Like like = new Like();

        like.setId( likeDTO.getId() );
        like.setVersion( likeDTO.getVersion() );
        like.setCreatedData( likeDTO.getCreatedData() );
        like.setCreatedBy( likeDTO.getCreatedBy() );
        like.setLastModifiedData( likeDTO.getLastModifiedData() );
        like.setLastModifiedBy( likeDTO.getLastModifiedBy() );
        like.setIsFavorite( likeDTO.getIsFavorite() );
        like.setUserApp( userAppMapper.toUserApp( likeDTO.getUserApp() ) );
        like.setPost( postMapper.toPost( likeDTO.getPost() ) );

        return like;
    }

    @Override
    public LikeDTO toLikeDTO(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeDTO likeDTO = new LikeDTO();

        likeDTO.setId( like.getId() );
        likeDTO.setVersion( like.getVersion() );
        likeDTO.setCreatedData( like.getCreatedData() );
        likeDTO.setCreatedBy( like.getCreatedBy() );
        likeDTO.setLastModifiedData( like.getLastModifiedData() );
        likeDTO.setLastModifiedBy( like.getLastModifiedBy() );
        likeDTO.setIsFavorite( like.getIsFavorite() );
        likeDTO.setUserApp( userAppMapper.toUserAppDTO( like.getUserApp() ) );
        likeDTO.setPost( postMapper.toPostDTO( like.getPost() ) );

        return likeDTO;
    }

    @Override
    public List<Like> toLikes(List<LikeDTO> likeDTOS) {
        if ( likeDTOS == null ) {
            return null;
        }

        List<Like> list = new ArrayList<Like>( likeDTOS.size() );
        for ( LikeDTO likeDTO : likeDTOS ) {
            list.add( toLike( likeDTO ) );
        }

        return list;
    }

    @Override
    public List<LikeDTO> toLikeDTOS(List<Like> likes) {
        if ( likes == null ) {
            return null;
        }

        List<LikeDTO> list = new ArrayList<LikeDTO>( likes.size() );
        for ( Like like : likes ) {
            list.add( toLikeDTO( like ) );
        }

        return list;
    }
}
