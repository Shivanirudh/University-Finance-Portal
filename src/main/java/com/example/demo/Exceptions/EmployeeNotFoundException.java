package com.example.demo.Exceptions;

import com.example.demo.Entities.Department;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

    EmployeeNotFoundException(Department department) {
        super("Could not find employees in department " + department.getDepartment_id());
    }
}
