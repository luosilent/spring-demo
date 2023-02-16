package com.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author luo
 * @date 2023/1/30 15:20
 */
@Configuration
public class RedisTemplateBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(RedisTemplate.class.isAssignableFrom(bean.getClass())) {
            RedisTemplate redisTemplate = (RedisTemplate)bean;
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            redisTemplate.setKeySerializer(stringRedisSerializer);
            redisTemplate.setValueSerializer(stringRedisSerializer);
        }
        return bean;
    }
}