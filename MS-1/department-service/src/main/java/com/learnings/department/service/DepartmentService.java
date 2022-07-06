package com.learnings.department.service;

import com.learnings.department.entity.Department;
import com.learnings.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> allDepartments() {
        List<Department> allDept=departmentRepository.findAll();
        if(allDept.isEmpty()){
            throw new IllegalStateException("No department exists");
        }
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        log.info("Inside addDepartment of DepartmentService");
        departmentRepository.save(department);
        return departmentRepository.save(department);
    }

    public Department getDepartment(long departmentId) {
        log.info("Inside getDepartment of DepartmentService");
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists){
//       throw new IllegalStateException("Department Id "+departmentId+" does not exists!");
            System.out.println("Department Id "+departmentId+" does not exists!");
            Department nullDepartment = new Department();
            nullDepartment.setDepartmentId(0);
            nullDepartment.setDepartmentName("Not Found");
            nullDepartment.setDepartmentAddress("Not Found");
            nullDepartment.setDepartmentCode("Not Found");
            return nullDepartment;
        }
        departmentRepository.findDepartmentBydepartmentId(departmentId);
        return departmentRepository.findDepartmentBydepartmentId(departmentId);
    }
}
