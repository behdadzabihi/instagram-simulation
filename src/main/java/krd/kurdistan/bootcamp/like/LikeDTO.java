package krd.kurdistan.bootcamp.like;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdistan.bootcamp.common.BaseDTO;
import krd.kurdistan.bootcamp.post.PostDTO;
import krd.kurdistan.bootcamp.user_app.UserAppDTO;
import lombok.Data;

@Data
public class LikeDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Boolean isFavorite;

    @ApiModelProperty(required = true,hidden = false)
    private UserAppDTO userApp;

    @ApiModelProperty(required = true,hidden = false)
    private PostDTO post;

}
