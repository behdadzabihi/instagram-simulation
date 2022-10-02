package krd.kurdistan.bootcamp.comment;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.kurdistan.bootcamp.post.PostMapper;
import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-01T23:52:39-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Autowired
    private UserAppMapper userAppMapper;
    @Autowired
    private PostMapper postMapper;

    @Override
    public Comment toComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentDTO.getId() );
        comment.setVersion( commentDTO.getVersion() );
        comment.setCreatedData( commentDTO.getCreatedData() );
        comment.setCreatedBy( commentDTO.getCreatedBy() );
        comment.setLastModifiedData( commentDTO.getLastModifiedData() );
        comment.setLastModifiedBy( commentDTO.getLastModifiedBy() );
        comment.setDate( commentDTO.getDate() );
        comment.setMessage( commentDTO.getMessage() );
        comment.setUserApp( userAppMapper.toUserApp( commentDTO.getUserApp() ) );
        comment.setPost( postMapper.toPost( commentDTO.getPost() ) );

        return comment;
    }

    @Override
    public CommentDTO toCommentDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId( comment.getId() );
        commentDTO.setVersion( comment.getVersion() );
        commentDTO.setCreatedData( comment.getCreatedData() );
        commentDTO.setCreatedBy( comment.getCreatedBy() );
        commentDTO.setLastModifiedData( comment.getLastModifiedData() );
        commentDTO.setLastModifiedBy( comment.getLastModifiedBy() );
        commentDTO.setDate( comment.getDate() );
        commentDTO.setMessage( comment.getMessage() );
        commentDTO.setUserApp( userAppMapper.toUserAppDTO( comment.getUserApp() ) );
        commentDTO.setPost( postMapper.toPostDTO( comment.getPost() ) );

        return commentDTO;
    }

    @Override
    public List<Comment> toComments(List<CommentDTO> commentDTOS) {
        if ( commentDTOS == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentDTOS.size() );
        for ( CommentDTO commentDTO : commentDTOS ) {
            list.add( toComment( commentDTO ) );
        }

        return list;
    }

    @Override
    public List<CommentDTO> toCommentDTOS(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toCommentDTO( comment ) );
        }

        return list;
    }
}
