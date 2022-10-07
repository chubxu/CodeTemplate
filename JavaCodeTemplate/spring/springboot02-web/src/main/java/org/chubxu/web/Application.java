package org.chubxu.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Springboot03webApplication
 * @Description 工程启动类
 * @Author chubxu
 * @Date 2021/1/9 17:59
 * @Since 1.0.0
 **/
@MapperScan(basePackages = "org.chubxu.web.dao")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
