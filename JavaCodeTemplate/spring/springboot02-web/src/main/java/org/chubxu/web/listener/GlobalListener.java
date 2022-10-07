package org.chubxu.web.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName GlobalListener
 * @Description 容器启动监听器
 * @Author chubxu
 * @Date 2021/1/10 11:30
 * @Version 1.0
 **/
@Component
public class GlobalListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("环境准备好了");
    }
}
