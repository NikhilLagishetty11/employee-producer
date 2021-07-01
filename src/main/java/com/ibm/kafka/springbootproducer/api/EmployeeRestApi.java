package com.ibm.kafka.springbootproducer.api;

import com.ibm.kafka.springbootproducer.requestDTO.AddEmployeeDetailsRequest;
import com.ibm.kafka.springbootproducer.requestDTO.DeleteEmployeeByIdRequest;
import com.ibm.kafka.springbootproducer.requestDTO.UpdateEmployeeByIdRequest;

import com.ibm.kafka.springbootproducer.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeRestApi {



    @Qualifier("employeeDetailsimpl")
    @Autowired
    EmployeeService service;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@RequestBody AddEmployeeDetailsRequest request) {
        log.info("Entered the add Employee Request");
        if (!request.getEmail().isEmpty()) {
            request.setEmail(request.getEmail().toLowerCase());
        }
        request.setEmpId("EmpID" +UUID.randomUUID().toString());
        service.addEmployeeDetails(request);
        return "Successfully added employee Details";
    }

    @PutMapping(value = "/update/{empId}")
    public String updateEmployeeById(@PathVariable String empId, @RequestBody UpdateEmployeeByIdRequest request){
        log.info("Entered the update Employee request");
        if (!request.getEmail().isEmpty()) {
            request.setEmail(request.getEmail().toLowerCase());
        }
        request.setEmpId(empId);
        service.updateEmployeeById(empId, request);
        return "Successfully updated employee Details";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteEmployeeById(@PathVariable DeleteEmployeeByIdRequest request){
        log.info("Entered the Delete Employee request");
        service.deleteEmployeeById(request.getEmpId());
        return "Successfully deleted employee";

    }
}
