package com.example.SpringBootRestApiWithJpaRepo.repo;

import com.example.SpringBootRestApiWithJpaRepo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
