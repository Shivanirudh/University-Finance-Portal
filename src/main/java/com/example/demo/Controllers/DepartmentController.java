package com.example.demo.Controllers;

import com.example.demo.Entities.Department;
import com.example.demo.Entities.Employee;
import com.example.demo.Exceptions.DepartmentNotFoundException;
import com.example.demo.Exceptions.EmployeeNotFoundException;
import com.example.demo.Services.DepartmentService;
import com.example.demo.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {
    public DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }
    @GetMapping("/departments/{id}")
    Department one(@PathVariable Long id) {

        return departmentService.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @PutMapping("/departments/{id}")
    Department updateDepartment(@RequestBody Department newDepartment, @PathVariable Long id) {

        return departmentService.findById(id)
                .map(department -> {
                    department.setDepartment_id(newDepartment.getDepartment_id());
                    department.setName(newDepartment.getName());
                    department.setCapacity(newDepartment.getCapacity());
                    return departmentService.update(department);
                })
                .orElseGet(() -> {
                    newDepartment.setDepartment_id(id);
                    return departmentService.update(newDepartment);
                });
    }

    @DeleteMapping("/departments/{id}")
    void deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
