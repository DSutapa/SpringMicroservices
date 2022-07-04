package com.learnings.department.service;

import com.learnings.department.entity.Department;
import com.learnings.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        departmentRepository.save(department);
        return departmentRepository.save(department);
    }

    public Department getDepartment(long departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if(!exists){
            throw new IllegalStateException("Department Id "+departmentId+" does not exists!");
        }
        departmentRepository.findDepartmentBydepartmentId(departmentId);
        return departmentRepository.findDepartmentBydepartmentId(departmentId);
    }
}
