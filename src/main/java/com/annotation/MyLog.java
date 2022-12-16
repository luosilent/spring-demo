package com.annotation;

import java.lang.annotation.*;

/**
 * @author luo
 * @date 2022/12/16 14:25
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyLog {
    String printLog();
}
