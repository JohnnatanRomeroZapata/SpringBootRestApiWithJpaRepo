package com.example.SpringBootRestApiWithJpaRepo.service;

import com.example.SpringBootRestApiWithJpaRepo.entity.Employee;
import com.example.SpringBootRestApiWithJpaRepo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }else{
            throw new RuntimeException(String.format("Employee with id %d does not exist", id));
        }

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}
