package krd.kurdistan.bootcamp.comment;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdistan.bootcamp.common.BaseDTO;
import krd.kurdistan.bootcamp.post.PostDTO;
import krd.kurdistan.bootcamp.user_app.UserAppDTO;
import lombok.Data;

import java.util.Date;


@Data
public class CommentDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Date date;

    @ApiModelProperty(required = true,hidden = false)
    private String message;

    @ApiModelProperty(required = true,hidden = false)
    private UserAppDTO userApp;

    @ApiModelProperty(required = true,hidden = false)
    private PostDTO post;


}
