package com.postgress.repository;

import com.postgress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /*List<Employee> findByFirstName(String FirstName);
    List<Employee> findAll();
    Employee findById(long id);*/
}
