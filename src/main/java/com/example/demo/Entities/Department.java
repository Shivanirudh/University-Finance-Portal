package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;

//    @Getter
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.ALL)
//    private List<Employee> employee;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long capacity;

//    public void setEmployee(List<Employee> employee) {
//        this.employee = employee;
//    }

    public Department() {

    }
    public Department(String name, Long capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public void setDepartment_id(Long departmentId) {
        this.department_id = departmentId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

}
