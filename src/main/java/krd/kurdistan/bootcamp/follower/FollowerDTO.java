package krd.kurdistan.bootcamp.follower;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdistan.bootcamp.common.BaseDTO;
import krd.kurdistan.bootcamp.user_app.UserAppDTO;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class FollowerDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String userName;

    @ApiModelProperty(required = false,hidden = false)
    private String profileImage;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean isFollower;

    @ApiModelProperty(required = true,hidden = false)
    private UserAppDTO userApp;
}
