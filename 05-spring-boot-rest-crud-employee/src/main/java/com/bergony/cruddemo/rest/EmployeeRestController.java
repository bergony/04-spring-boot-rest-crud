package com.bergony.cruddemo.rest;

import com.bergony.cruddemo.entity.Employee;
import com.bergony.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    private List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    private Employee findEmployeeById(@PathVariable int employeeId){

        Employee updateEmployee = employeeService.findById(employeeId);

        if(updateEmployee == null )
            throw new RuntimeException("Employee id not found - " + employeeId);
        return  updateEmployee;
    }

    @PostMapping()
    private Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return  employeeService.save(employee);
    }

    @PutMapping()
    private Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);

    }

    @DeleteMapping("/{employeeId}")
    private String deleteEmployeeById(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(tempEmployee == null )
            throw new RuntimeException("Employee id not found - " + employeeId);

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
