package com.ddd.controllers;

import com.ddd.entitys.*;
import com.ddd.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //属于controller+respondbody的一个合集
@RequestMapping("/requirement") //通过/requirement找到TestController这个类
public class TestController {

    //MVC(
    // M-model-模型 javabean --业务bean（业务，数据库交互，---业务bean和dao），承载数据的bean（只包含私有属性和共有get/set方法的类）
    // V-view-视图(jsp),freemarker,velocity,themleaf等等,进行用户数据的收集，进行页面的渲染
    // C-controller-控制器(serlvet),只负责两件事:接受页面的参数，携带数据进行页面跳转

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/getAge")
    public List<Age> getAge(){
        System.out.println("getAge...");
        List<Age> list1 = userService.getAge();
        for (Age age : list1) {
            System.out.println(age);
        }
        return list1;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getNorth_america")
    public List<north_america> getNorth_america(){
        System.out.println("getNorth_america...");
        List<north_america> list2 = userService.getNorth_america();
        for (north_america na : list2) {
            System.out.println(na);
        }
        return list2;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getEurope")
    public List<europe> getEurope(){
        System.out.println("getEurope...");
        List<europe> list3 = userService.getEurope();
        for (europe eu : list3) {
            System.out.println(eu);
        }
        return list3;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getAsia")
    public List<asia> getAsia(){
        System.out.println("getAsia...");
        List<asia> list4 = userService.getAsia();
        for (asia as : list4) {
            System.out.println(as);
        }
        return list4;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getAfrica")
    public List<africa> getAfrica(){
        System.out.println("getAfrica...");
        List<africa> list5 = userService.getAfrica();
        for (africa af : list5) {
            System.out.println(af);
        }
        return list5;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getOceania")
    public List<oceania> getOceania(){
        System.out.println("getOceania...");
        List<oceania> list6 = userService.getOceania();
        for (oceania oc : list6) {
            System.out.println(oc);
        }
        return list6;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getSouth_america")
    public List<south_america> getSouth_america(){
        System.out.println("getSouth_america...");
        List<south_america> list7 = userService.getSouth_america();
        for (south_america sa : list7) {
            System.out.println(sa);
        }
        return list7;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getAirport")
    public List<airport> getAirport(){
        System.out.println("getAirport...");
        List<airport> list8 = userService.getAirport();
        for (airport ap : list8) {
            System.out.println(ap);
        }
        return list8;    //会自动将返回值转换成json串
    }

    @RequestMapping("/getGetcounts")
    public List<getcounts> getGetcounts(){
        System.out.println("getGetcountst...");
        List<getcounts> list9 = userService.getGetcounts();
        for (getcounts gc : list9) {
            System.out.println(gc);
        }
        return list9;    //会自动将返回值转换成json串
    }
    @RequestMapping("/getGetAirline")
    public List<airline> getAirline(){
        System.out.println("getGetcountst...");
        List<airline> list10 = userService.getAirline();
        for (airline gc : list10) {
            System.out.println(gc);
        }
        return list10;    //会自动将返回值转换成json串
    }

}
