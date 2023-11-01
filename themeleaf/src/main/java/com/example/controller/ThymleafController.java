package com.example.controller;

import com.example.po.Address;
import com.example.po.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.nio.charset.Charset;

@Controller
@RequestMapping("/thymleafController")
public class ThymleafController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "{'info':'hello'}";

    }

    /**
     * 在Model里存入一个用户信息
     * @return hello页面
     */
    @RequestMapping("returnModelAndView")
    public String returnModelAndView(Model model){
        model.addAttribute("userInfo",new UserInfo("lomtom","123",new Address("湖南","邵阳")));
        model.addAttribute("userInfo1",new UserInfo("lomtom","123",new Address("湖南","邵阳")));
        model.addAttribute("userInfo2",new UserInfo("lomtom","123",new Address("湖南","邵阳")));
        return "hello";
    }
}
