package com.web.mapper;

import com.web.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luo
 * @since 2022-12-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
