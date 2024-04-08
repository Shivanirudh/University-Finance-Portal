package com.example.demo.Services;

import com.example.demo.Entities.Department;
import com.example.demo.Repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository = null;

    public DepartmentService() {
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> findAll(){
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);

        return departments;
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
