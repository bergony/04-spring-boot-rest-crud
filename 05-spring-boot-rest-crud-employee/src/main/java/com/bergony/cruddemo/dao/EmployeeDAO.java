package com.bergony.cruddemo.dao;

import com.bergony.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findALL();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
