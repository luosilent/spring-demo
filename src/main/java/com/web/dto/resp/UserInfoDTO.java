package com.web.dto.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;


/**
 * @author luo
 * @date 2022/12/12 11:04
 */

@Data
@Builder
public class UserInfoDTO {

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
