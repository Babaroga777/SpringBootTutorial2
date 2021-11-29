package com.itkolleg.SpringBoot.tutorial.controller;

import com.itkolleg.SpringBoot.tutorial.entity.Department;
import com.itkolleg.SpringBoot.tutorial.error.DepartmentNotFoundException;
import com.itkolleg.SpringBoot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    //Creates a reference to the particular object
    @Autowired
    private DepartmentService departmentService;

    //Initialises loggers from the SLF4J Library
    public  final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    //This method saves a Department in the database
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){

        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    /**
     * Method to get all the Departments from the Database.
     * We use the List Class and the Repository to return
     */
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    /**
     * fetches the data of department by ID
     * Die geschwungenen Klammern bedeuten dynamic Value
     */
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    /**
     * Deletes a Department by ID
     * same Path Variable as for fetchingDepartmentById
     * @param departmentId
     * @return Message
     */
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully!";
    }

    /**
     * This Method updates a department by ID
     * PutMapping -> annotation for updating
     * @param departmentId
     * @param department
     * @return department
     */
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    /**
     * This method fetches a department by name
     * @param departmentName
     * @return department
     */
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
