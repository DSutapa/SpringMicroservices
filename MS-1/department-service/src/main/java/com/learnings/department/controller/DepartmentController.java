package com.learnings.department.controller;

import com.learnings.department.entity.Department;
import com.learnings.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
       return departmentService.addDepartment(department);

    }
    @GetMapping(path="/{departmentId}")
    public Department getDepartment(@PathVariable ("departmentId") long departmentId){
        return departmentService.getDepartment(departmentId);
    }
}
