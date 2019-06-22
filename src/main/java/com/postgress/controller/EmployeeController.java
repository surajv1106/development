package com.postgress.controller;


import java.util.Optional;
import com.postgress.error.CustomErrorType;
import com.postgress.model.Employee;
import com.postgress.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository repository;



    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeess = repository.findAll();
        if(employeess.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(employeess);
        //return new ResponseEntity<List<Employee>>(employeess, HttpStatus.OK);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        //logger.info("Fetching User with id {}", id);
        Optional<Employee> employee = repository.findById(id);
        if (employee == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("User with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        return ResponseEntity.ok(employee.get());
    }


    @PostMapping("/addEmployee")
    public ResponseEntity create(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(repository.save(employee));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        if (!repository.findById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        employee.setId(id);
        return ResponseEntity.ok(repository.save(employee));
        //return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!repository.findById(id).isPresent()) {
            logger.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        repository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}


