package com.nc.controller;

import com.nc.enities.EmployeeEntity;
import com.nc.repository.EmpRepository;
import com.nc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmpService empService;

    @PostMapping("/save")
    public EmployeeEntity save(@RequestBody EmployeeEntity employeeEntity) {
        return empService.saveEmp(employeeEntity);
    }

    @GetMapping("/get")
    public EmployeeEntity get(@RequestParam("id") long id) throws UserPrincipalNotFoundException {
        return empService.findEmp(id);
    }

    @GetMapping("/get-all")
    public List<EmployeeEntity> getall() throws UserPrincipalNotFoundException {
        return empService.finalAll();
    }
}
