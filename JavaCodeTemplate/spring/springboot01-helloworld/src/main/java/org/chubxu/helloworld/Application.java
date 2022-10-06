package org.chubxu.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Description 整个应用的启动入口
 * @Since 1.0.0
 * @Date 2022/10/6 18:46
 * @Author chubxu
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
