package com.ibm.kafka.springbootproducer.service;

import com.ibm.kafka.springbootproducer.requestDTO.AddEmployeeDetailsRequest;
import com.ibm.kafka.springbootproducer.requestDTO.UpdateEmployeeByIdRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EmployeeDetailsimpl implements EmployeeService {


    public static final String topic = "first_topic";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void addEmployeeDetails(AddEmployeeDetailsRequest request){
        log.info("entered the add employee details service");
        this.kafkaTemplate.send(topic,request.toString());
    }

    public void updateEmployeeById(String empId, UpdateEmployeeByIdRequest request){
        log.info("entered the update employee details service");
        this.kafkaTemplate.send(topic,empId,request.toString());

    }

    public  void deleteEmployeeById(String empId){
        log.info("entered the delete employee service");
        this.kafkaTemplate.send(topic,empId);
    }
}
