package com.web.controller;


import com.web.dto.req.UserInfoSaveDTO;
import com.web.service.IUserInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luo
 * @since 2022-12-12
 */
@Api(tags = {"userInfo"})
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource
    IUserInfoService iUserInfoService;

    @PostMapping("/add")
    public void add(@RequestBody UserInfoSaveDTO req){
        iUserInfoService.add(req);
    }

}
