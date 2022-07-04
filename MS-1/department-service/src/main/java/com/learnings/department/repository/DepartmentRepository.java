package com.learnings.department.repository;

import com.learnings.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentBydepartmentId(long departmentId);
}
