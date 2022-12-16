package com.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.dto.req.UserInfoSaveDTO;
import com.web.entity.UserInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luo
 * @since 2022-12-12
 */
public interface IUserInfoService extends IService<UserInfo> {

    /**
     * 添加
     * @param req
     */
    void add(UserInfoSaveDTO req);


}
