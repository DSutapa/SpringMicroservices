package com.learnings.user.controller;

import com.learnings.user.VO.ResponseTemplateVO;
import com.learnings.user.entity.Users;
import com.learnings.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(path="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path="/allUsers")
    public List<Users> allUsers(){
        return userService.allUsers();
    }
    @PostMapping(path="/addUser")
    public Users addUser(@RequestBody Users users){
        log.info("Inside addUser of UserController");
        return userService.addUser(users);
    }
//    @GetMapping(path="/{userId}")
//    public Users getUser(@PathVariable ("userId") long userId){
//        return userService.getUser(userId);
//    }

    @GetMapping(path="/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable ("userId") long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
