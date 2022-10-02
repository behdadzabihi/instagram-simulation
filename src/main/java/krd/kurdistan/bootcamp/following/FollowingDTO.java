package krd.kurdistan.bootcamp.following;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdistan.bootcamp.common.BaseDTO;
import krd.kurdistan.bootcamp.user_app.UserAppDTO;
import lombok.Data;

@Data
public class FollowingDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String userName;

    @ApiModelProperty(required = false,hidden = false)
    private String profileImage;

    @ApiModelProperty(required = false,hidden = false)
    private Boolean removeFromFallowingList;

    @ApiModelProperty(required = true,hidden = false)
    private UserAppDTO userApp;
}
