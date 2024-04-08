package com.example.demo.Exceptions;

public class EmployeeSalaryNotFoundException extends RuntimeException{
    public EmployeeSalaryNotFoundException(Long id) {
        super("Could not find employee salary " + id);
    }

}
