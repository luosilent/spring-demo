package com;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author admin
 */
@Slf4j
@MapperScan("com.web.mapper")
@SpringBootApplication
public class ProDemoApplication {

    public static void main(String[] args) {
        log.info("服务开始启动......");
        SpringApplication.run(ProDemoApplication.class, args);
    }

}
