package com.example.SpringBootRestApiWithJpaRepo.controller;

import com.example.SpringBootRestApiWithJpaRepo.entity.Employee;
import com.example.SpringBootRestApiWithJpaRepo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeeById(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException(String.format("Employee id : %d not found", employeeId));
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee employeeToDelete = employeeService.findById(id);

        if(employeeToDelete == null){
            throw new RuntimeException(String.format("Employee with id %d does not exist", id));
        }

        employeeService.deleteById(id);
    }
}
