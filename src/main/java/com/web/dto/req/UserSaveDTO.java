package com.web.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author luo
 * @date 2022/12/12 11:04
 */

@Data
public class UserSaveDTO {

    @ApiModelProperty("用户id")
    private String name;

    @ApiModelProperty("平台id")
    private Integer gender;


    @Override
    public String toString() {
        return "UserSaveDTO{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
