package com.learnings.department.controller;

import com.learnings.department.entity.Department;
import com.learnings.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(path="/departments/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path="/allDepartments")
    public List<Department> allDepartments(){
        return departmentService.allDepartments();
    }
    @PostMapping(path="/addDepartment")
    public Department addDepartment(@RequestBody Department department){
        log.info("Inside addDepartment of DepartmentController");
       return departmentService.addDepartment(department);

    }
    @GetMapping(path="/{departmentId}")
    public Department getDepartment(@PathVariable ("departmentId") long departmentId){
        log.info("Inside getDepartment of DepartmentController");
        return departmentService.getDepartment(departmentId);
    }
}
