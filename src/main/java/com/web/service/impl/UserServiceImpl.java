package com.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exception.BusinessException;
import com.web.dto.req.UserSaveDTO;
import com.web.entity.User;
import com.web.entity.UserLog;
import com.web.mapper.UserLogMapper;
import com.web.mapper.UserMapper;
import com.web.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author luo
 * @since 2022-12-12
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserLogMapper userLogMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserSaveDTO req) {
        log.info("add user {}", req);
        userMapper.insert(User.builder().name(req.getName()).gender(req.getGender()).build());
        addLog(req);
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @Override
    public User get(Integer id) {
        return userMapper.selectById(id);
    }

    private void addLog(UserSaveDTO req) {
        log.info("add userLog {}", req);
        if ("".equals(req.getName())) {
            throw new BusinessException(300, "error ");
        }
        userLogMapper.insert(UserLog.builder().name(req.getName()).gender(req.getGender()).build());
    }

}
