package com.nc.controller;

import com.nc.enities.Department;
import com.nc.enities.EmployeeEntity;
import com.nc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    EmpService empService;

    @PostMapping("/save")
    public Department save(@RequestBody Department department) {
        return empService.save(department);
    }

    @GetMapping("/get")
    public Department get(@RequestParam("id") String id) throws UserPrincipalNotFoundException {
        return empService.findByIdDepartment(id);
    }

    @GetMapping("/get-all")
    public List<Department> getall() throws UserPrincipalNotFoundException {
        return empService.findAllDepartment();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") String id) throws UserPrincipalNotFoundException {
        return empService.deleteById(id);
    }
}
