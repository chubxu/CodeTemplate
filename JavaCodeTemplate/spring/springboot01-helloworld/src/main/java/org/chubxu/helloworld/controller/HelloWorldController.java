package org.chubxu.helloworld.controller;

import org.chubxu.common.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
