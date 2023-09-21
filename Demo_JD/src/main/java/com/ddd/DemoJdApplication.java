package com.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //标记当前类是一个控制器（selevet），这种没有映射的controller只能有一个
@SpringBootApplication  //标记当前类是一个springboot应用
public class DemoJdApplication {

    public static void main(String[] args) {
        System.out.println("开始。。。");
        SpringApplication.run(DemoJdApplication.class, args);
        System.out.println("结束。。。");
    }

    @RequestMapping("/hello")   //将此方法hello()映射为字符串”/hello",通过/hello这个字符串找到hello这个方法
    @ResponseBody   //将此方法的返回值放入响应体中（通常为json）
    public String hello() {
        return "hello jd";  //字符串
    }

    @RequestMapping("/index")
    public String index() {
        return "index"; //没有ResponseBody，返回的是视图名称（逻辑名称），叫页面名称
    }
}
