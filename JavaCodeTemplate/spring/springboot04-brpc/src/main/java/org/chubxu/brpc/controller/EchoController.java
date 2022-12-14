package org.chubxu.brpc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EchoController
 * @Description TODO
 * @Since 1.0.0
 * @Date 2022/12/14 21:48
 * @Author chubxu
 */
@RestController
public class EchoController {
    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }
}
