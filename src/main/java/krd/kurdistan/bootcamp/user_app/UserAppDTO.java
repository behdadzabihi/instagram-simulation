package krd.kurdistan.bootcamp.user_app;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdistan.bootcamp.common.BaseDTO;
import lombok.Data;



@Data
public class UserAppDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String firstName;

    @ApiModelProperty(required = true,hidden = false)
    private String lastName;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = true,hidden = false)
    private String email;

    @ApiModelProperty(required = true,hidden = false)
    private String userName;

    @ApiModelProperty(required = true,hidden = false)
    private String password;

    @ApiModelProperty(required = false,hidden = false)
    private String profileImage;

    @ApiModelProperty(required = false,hidden = false)
    private String bio;

    @ApiModelProperty(required = true,hidden = false)
    private Long postCount;

    @ApiModelProperty(required = true,hidden = false)
    private Long followerCount;

    @ApiModelProperty(required = true,hidden = false)
    private Long followingCount;
}
