package com.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.dto.req.UserSaveDTO;
import com.web.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luo
 * @since 2022-12-12
 */
public interface IUserService extends IService<User> {

    /**
     * 添加
     * @param req
     */
    void add(UserSaveDTO req);



}
