package com.example.demo.Config;

import com.example.demo.Entities.Employee;
import com.example.demo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
@EnableSpringDataWebSupport
public class SpringSecurity {

    @Autowired
    private EmployeeService employeeService;
}
