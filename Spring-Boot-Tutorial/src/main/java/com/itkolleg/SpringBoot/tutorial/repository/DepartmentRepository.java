package com.itkolleg.SpringBoot.tutorial.repository;

import com.itkolleg.SpringBoot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //IgnoreCase means case insensitive
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
