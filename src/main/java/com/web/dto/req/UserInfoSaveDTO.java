package com.web.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author luo
 * @date 2022/12/12 11:04
 */

@Data
public class UserInfoSaveDTO {

    @ApiModelProperty("用户a")
    private String nameA;

    @ApiModelProperty("用户b")
    private String nameB;

    @ApiModelProperty("用户c")
    private String nameC;

    @ApiModelProperty("用户d")
    private String nameD;

    @ApiModelProperty("性别")
    private Integer gender;

    @ApiModelProperty("age")
    private Integer age;


}
