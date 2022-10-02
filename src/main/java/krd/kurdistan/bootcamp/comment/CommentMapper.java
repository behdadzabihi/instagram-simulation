package krd.kurdistan.bootcamp.comment;


import krd.kurdistan.bootcamp.post.PostMapper;
import krd.kurdistan.bootcamp.user_app.UserAppMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserAppMapper.class, PostMapper.class})

public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);

    CommentDTO toCommentDTO(Comment comment);

    List<Comment> toComments(List<CommentDTO> commentDTOS);

    List<CommentDTO> toCommentDTOS(List<Comment> comments);

}
