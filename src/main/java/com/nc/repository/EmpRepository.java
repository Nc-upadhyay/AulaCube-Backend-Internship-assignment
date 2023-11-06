package com.nc.repository;

import com.nc.enities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmployeeEntity, Long> {

}
