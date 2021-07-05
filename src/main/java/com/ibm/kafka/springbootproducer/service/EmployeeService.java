package com.ibm.kafka.springbootproducer.service;


import com.ibm.kafka.springbootproducer.requestDTO.AddEmployeeDetailsRequest;
import com.ibm.kafka.springbootproducer.requestDTO.DeleteEmployeeByIdRequest;
import com.ibm.kafka.springbootproducer.requestDTO.Employee;
import com.ibm.kafka.springbootproducer.requestDTO.UpdateEmployeeByIdRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    void addEmployeeDetails(Employee request);

    void updateEmployeeById(String empId, Employee request);

    void deleteEmployeeById(String empId);
}
