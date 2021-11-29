package com.itkolleg.SpringBoot.tutorial.service;

import com.itkolleg.SpringBoot.tutorial.entity.Department;
import com.itkolleg.SpringBoot.tutorial.error.DepartmentNotFoundException;
import com.itkolleg.SpringBoot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;


    /**
     * This Method saves the data of a JSON file in the database - entity Department
     * @param department
     * @return Enitity department
     */
    @Override
    public Department saveDepartment(Department department) {

        return departmentRepository.save(department); //Methods from the JPA repository we have extended
    }

    /**
     * This Method fetches all the departments available in our database
     * the function findAll returnes a List of Departments
     */
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    //This Method fetches the data of a department by the Department ID
    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Deparment Not Available!");
        }
        return department.get();
    }


    //Deletes a department by ID and uses the Method of the repository - deleteById()
    @Override
    public void deleteDepartmentById(Long departmentId) {

        departmentRepository.deleteById(departmentId);
    }


    /**
     * Udates the data of a department, puts department found by ID in a new department object - departmentDatabase
     * Checks for null and empty objects
     * @param departmentId
     * @param department
     * @return
     */
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDatabase = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName())&&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDatabase.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDatabase.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDatabase.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(departmentDatabase);
    }


    /**
     * There is no default method in the repository
     * so we create in DepartmentRepository class the method fetchDepartmentByName()
     * This method fetches a department by name
     * IGNORECASE in findByDepartmentName means it will not be case sensitive
     * This is how we can implement the different JPA-Methods
     * @param departmentName
     * @return department
     */
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
