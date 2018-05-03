package me.readyou.springbootlearn.controller;

import me.readyou.springbootlearn.starter.stringhandler.StringHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuxinlong on 18/5/2.
 */
@RestController
public class HelloController {
    @Autowired
    private StringHandlerService stringHandlerService;

    // 这里不再需要@ResponseBody注解
    @RequestMapping("/")
    String home() {
        String msg = "Hello World!";
        return stringHandlerService.doHandle(msg);
    }
}
