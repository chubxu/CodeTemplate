package org.chubxu.brpc;

import com.baidu.cloud.starlight.springcloud.server.annotation.StarlightScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/12/12 22:06
 * @Author chubxu
 */
@SpringBootApplication
@StarlightScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
