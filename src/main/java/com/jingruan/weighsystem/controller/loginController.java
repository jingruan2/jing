package com.jingruan.weighsystem.controller;

import com.jingruan.weighsystem.util.CreateJwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {
    @ResponseBody
    @PostMapping("login/getToken")
    public Map<String,Object> getToken(String username, String password, String depart){
        Map<String,Object> m1 = new HashMap<>();
        Map<String,Object> m2 = new HashMap<>();
        Date date = new Date();
        System.out.println(password);
        String token1 = CreateJwt.getToken(username,date,password);
        m2.put("leve",1);
        m2.put("token",token1);
        m2.put("username",username);
        m2.put("depart",depart);
        m2.put("log_time",date.getTime());
        m2.put("last_login_time",0);
        m1.put("code",200);
        m1.put("data",m2);
        return m1;
    }
}
