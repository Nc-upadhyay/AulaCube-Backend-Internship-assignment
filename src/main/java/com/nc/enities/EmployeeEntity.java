package com.nc.enities;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "emp_table")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date createdAt;
    private Date updatedAt;

}
