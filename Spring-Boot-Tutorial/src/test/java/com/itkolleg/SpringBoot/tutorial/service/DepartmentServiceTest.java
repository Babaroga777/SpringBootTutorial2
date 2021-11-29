package com.itkolleg.SpringBoot.tutorial.service;

import com.itkolleg.SpringBoot.tutorial.entity.Department;
import com.itkolleg.SpringBoot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest  //This annotation tells Springboot that this is a testclass
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;


    @MockBean  //Annotation Mocking
    private DepartmentRepository departmentRepository;

    @BeforeEach
    //@BeforeAll
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Innsbruck")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based Valid Department Name")
    //@Disabled // Annotation to skip the testing

    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}