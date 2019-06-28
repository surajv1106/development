package com.postgress.model;

import java.util.List;

public class EmployeeDetails {

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    private List<Employee> list;


}
