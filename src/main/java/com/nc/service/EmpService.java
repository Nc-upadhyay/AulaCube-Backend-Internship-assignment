package com.nc.service;

import com.nc.enities.Department;
import com.nc.enities.EmployeeEntity;
import com.nc.repository.DepartmentRepo;
import com.nc.repository.EmpRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.UnmodifiableSetException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DepartmentRepo departmentRepo;

    public EmployeeEntity saveEmp(EmployeeEntity emp) {
        emp.setCreatedAt(new Date());
        emp.setUpdatedAt(new Date());
        return empRepository.save(emp);
    }

    public EmployeeEntity findEmp(Long id) throws UserPrincipalNotFoundException {
        return empRepository.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException(" User not exist"));
    }

    public List<EmployeeEntity> finalAll() {
        return empRepository.findAll();
    }

    public EmployeeEntity updateEmp(EmployeeEntity emp) {
        EmployeeEntity employeeEntity = empRepository.findById(emp.getId()).orElseThrow(() -> new UnmodifiableSetException("User not fund, we can't process request"));
        emp.setId(emp.getId());
        return empRepository.save(emp);
    }

    public EmployeeEntity deleteEmp(Long emp) {
        EmployeeEntity employeeEntity = empRepository.findById(emp).orElseThrow(() -> new UnmodifiableSetException("User not fund, we can't process request"));
        empRepository.deleteById(emp);
        return employeeEntity;

    }

    // Department CRUD method
    public Department save(Department entity) {
        return departmentRepo.save(entity);
    }

    public List<Department> findAllDepartment() {
        return departmentRepo.findAll();
    }

    public Department findByIdDepartment(String id) throws UserPrincipalNotFoundException {
        return departmentRepo.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException("User Not found"));
    }

    public String deleteById(String id) {
        departmentRepo.deleteById(id);
        Department department = departmentRepo.findById(id).orElse(new Department());
        if (department.getDepartmentId() == null)
            return "Delete successfully";
        else
            return "There is some error ";
    }

    public void update(Department department) throws UserPrincipalNotFoundException {
        departmentRepo.findById(department.getDepartmentId()).orElseThrow(() -> new UserPrincipalNotFoundException("Cant update data because user not found"));
        departmentRepo.save(department);
    }


}
