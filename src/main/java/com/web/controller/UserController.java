package com.web.controller;


import com.web.dto.req.UserSaveDTO;
import com.web.service.IUserService;
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
@Api(tags = {"user"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IUserService iUserService;

    @PostMapping("/add")
    public void add(@RequestBody UserSaveDTO req){
        iUserService.add(req);
    }

}
