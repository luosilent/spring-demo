package com.web.controller;

import com.annotation.MyLog;
import com.web.dto.req.UserSaveDTO;
import com.web.entity.User;
import com.web.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
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
    @MyLog(printLog = "add")
    public void add(@RequestBody UserSaveDTO req) {
        iUserService.add(req);
    }

    @PostMapping("/get")
    @MyLog(printLog = "get")
    public User get(@RequestParam Integer id) {
        return iUserService.get(id);
    }

}
