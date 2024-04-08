package com.example.demo.Repositories;

import com.example.demo.Entities.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    Department findDepartmentByName(String name);
//    @Query("select d from department d where d.department_id = ?")
//    Department findDepartmentByDepartment_id(Long id);

}
