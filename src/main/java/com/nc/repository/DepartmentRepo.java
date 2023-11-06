package com.nc.repository;

import com.nc.enities.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepo extends MongoRepository<Department,String > {
}
