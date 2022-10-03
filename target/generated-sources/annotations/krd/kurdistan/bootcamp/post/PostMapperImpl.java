package krd.kurdistan.bootcamp.post;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T02:13:38-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDTO.getId() );
        post.setVersion( postDTO.getVersion() );
        post.setCreatedData( postDTO.getCreatedData() );
        post.setCreatedBy( postDTO.getCreatedBy() );
        post.setLastModifiedData( postDTO.getLastModifiedData() );
        post.setLastModifiedBy( postDTO.getLastModifiedBy() );
        post.setTitle( postDTO.getTitle() );
        post.setPostLink( postDTO.getPostLink() );
        post.setDescription( postDTO.getDescription() );

        return post;
    }

    @Override
    public PostDTO toPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( post.getId() );
        postDTO.setVersion( post.getVersion() );
        postDTO.setCreatedData( post.getCreatedData() );
        postDTO.setCreatedBy( post.getCreatedBy() );
        postDTO.setLastModifiedData( post.getLastModifiedData() );
        postDTO.setLastModifiedBy( post.getLastModifiedBy() );
        postDTO.setTitle( post.getTitle() );
        postDTO.setPostLink( post.getPostLink() );
        postDTO.setDescription( post.getDescription() );

        return postDTO;
    }

    @Override
    public List<Post> toPosts(List<PostDTO> postDTOS) {
        if ( postDTOS == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( postDTOS.size() );
        for ( PostDTO postDTO : postDTOS ) {
            list.add( toPost( postDTO ) );
        }

        return list;
    }

    @Override
    public List<PostDTO> toPostDTOS(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( posts.size() );
        for ( Post post : posts ) {
            list.add( toPostDTO( post ) );
        }

        return list;
    }
}
