package com.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.dto.req.UserInfoSaveDTO;
import com.web.entity.UserInfo;
import com.web.mapper.UserInfoMapper;
import com.web.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    private final static int MAX_NUM = 200000;
    private final static int LIST_NUM = 500;


    /**
     * 添加
     *
     * @param req
     */
    @Override
    public void add(UserInfoSaveDTO req) {
        Collection<UserInfo> allList = new ArrayList<>(MAX_NUM);
        for (int i = 0; i < MAX_NUM; i++) {
            int num = new Random().nextInt(100);
            String name = get4UUID();
            allList.add(UserInfo.builder()
                    .nameA(name +"-a" + num)
                    .nameB(name +"-b" + num)
                    .nameC(name +"-c" + num)
                    .nameD(name +"-d" + num)
                    .gender(new Random().nextInt(2))
                    .age(num)
                    .deleteFlag(false)
                    .createTime(new Date())
                    .build());
        }
        List<Collection<UserInfo>> userInfoList = new ArrayList<>();
        Stream.iterate(0, n -> n + 1).limit(MAX_NUM / LIST_NUM).forEach(i -> {
            System.out.println(i);
            userInfoList.add(allList.stream().skip((long) i * LIST_NUM).limit(LIST_NUM).collect(Collectors.toList()));
        });
        log.info("userInfoList : {}", JSON.toJSONString(userInfoList));
        log.info("多线程拆分，线程数量:[{}]", userInfoList.size());
        for (Collection<UserInfo> userInfos : userInfoList) {
            log.info("当前线程id:[{}]", Thread.currentThread().getId());
            taskExecutor.execute(() -> saveBatch(userInfos));
        }
    }


    /**
     * 获得4个长度的十六进制的UUID
     *
     * @return UUID
     */
    public static String get4UUID() {
        UUID id = UUID.randomUUID();
        String[] idd = id.toString().split("-");
        return idd[1];
    }
}
