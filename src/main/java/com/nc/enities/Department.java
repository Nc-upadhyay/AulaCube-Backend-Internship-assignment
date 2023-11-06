package com.nc.enities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "department")
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private Date createdAt = new Date();
    private Date updatedAt = new Date();
}
