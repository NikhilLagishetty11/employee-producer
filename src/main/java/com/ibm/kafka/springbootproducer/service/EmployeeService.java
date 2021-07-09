package com.ibm.kafka.springbootproducer.service;


import com.ibm.kafka.springbootproducer.requestDTO.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    void addEmployeeDetails(Employee request);

    void updateEmployeeById(Employee request);

    void deleteEmployeeById(String email);
}
