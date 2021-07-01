package com.ibm.kafka.springbootproducer.service;


import com.ibm.kafka.springbootproducer.requestDTO.AddEmployeeDetailsRequest;
import com.ibm.kafka.springbootproducer.requestDTO.UpdateEmployeeByIdRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    void addEmployeeDetails(AddEmployeeDetailsRequest request);

    void updateEmployeeById(String empId, UpdateEmployeeByIdRequest request);

    void deleteEmployeeById(String empId);
}
