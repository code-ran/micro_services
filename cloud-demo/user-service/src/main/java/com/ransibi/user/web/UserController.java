package com.ransibi.user.web;

import com.ransibi.user.config.PatternProperties;
import com.ransibi.user.pojo.User;
import com.ransibi.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${pattern.dateformat}")
//    private String dateFormat;

    @Autowired
    private PatternProperties patternProperties;


    @GetMapping("/share")
    public PatternProperties getEnv(){
        return patternProperties;
    }


    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    @GetMapping("/nowTime")
    public String getNowTime() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(patternProperties.getDateFormat());
        return dateFormat1.format(new Date());
    }
}
