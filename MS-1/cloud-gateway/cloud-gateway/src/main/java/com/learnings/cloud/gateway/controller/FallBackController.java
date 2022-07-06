package com.learnings.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/user-service-fallback")
    public String userServiceFallBack(){
        return "User Service Taking Too Long Time To Respond.";
    }

    @GetMapping("/department-service-fallback")
    public String departmentServiceFallBack(){
        return "Department Service Taking Too Long Time To Respond.";
    }
}
