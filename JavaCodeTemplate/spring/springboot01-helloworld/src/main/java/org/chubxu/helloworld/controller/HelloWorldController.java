package org.chubxu.helloworld.controller;

import org.chubxu.common.R;
import org.chubxu.easylog.annotation.ELog;
import org.chubxu.helloworld.factory.bean.FirstBean;
import org.chubxu.helloworld.factory.bean.FirstFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HelloWorldController
 * @Description HelloWorld 控制器
 * @Since 1.0.0
 * @Date 2022/10/6 18:46
 * @Author chubxu
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public R<String> hello(){
        return new R<String>().ok().setData("Hello World");
    }

    @ELog
    @RequestMapping("/test/easylog")
    public R<String> testEasyLog(){
        return new R<String>().ok().setData("Hello EasyLog");
    }
}
