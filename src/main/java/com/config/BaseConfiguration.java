package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class BaseConfiguration {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        //核心线程数
        pool.setCorePoolSize(15);
        //最大线程数
        pool.setMaxPoolSize(50);
        //线程最大空闲时间
        pool.setKeepAliveSeconds(120);
        //队列大小
        pool.setQueueCapacity(1000);
        pool.setThreadNamePrefix("test");
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return pool;
    }

}
