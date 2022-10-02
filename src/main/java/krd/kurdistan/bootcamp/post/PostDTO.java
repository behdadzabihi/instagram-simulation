package krd.kurdistan.bootcamp.post;

import io.swagger.annotations.ApiModelProperty;
import krd.kurdistan.bootcamp.common.BaseDTO;
import lombok.Data;

@Data
public class PostDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private String postLink;

    @ApiModelProperty(required = false,hidden = false)
    private String description;
}
