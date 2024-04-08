package com.example.demo.Entities;



public class EmpSaveDto {


    private String first_name;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    private String last_name;

    private String email;

    private String title;

    public EmpSaveDto(String first_name, String last_name, String email, String title, String photograph_path, Long department_id, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
        this.photograph_path = photograph_path;
        this.department_id = department_id;
        this.password = password;
    }

    private String photograph_path;

    private Long department_id;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


}
