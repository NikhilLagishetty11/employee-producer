package com.ibm.kafka.springbootproducer.service;


import com.ibm.kafka.springbootproducer.requestDTO.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EmployeeDetailsimpl implements EmployeeService {


    public static final String topic = "second_topic";

    public static final String deleteEmployeeTopic = "delete_employee_topic";

    @Autowired
    private KafkaTemplate<String, Employee>kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, String> deleteEmployeeByIdKafkaTemplate;


    public void addEmployeeDetails(Employee request){
        log.info("entered the add employee details service");
        this.kafkaTemplate.send(topic,request);
    }

    public void updateEmployeeById(String empId, Employee request){
        log.info("entered the update employee details service");
        this.kafkaTemplate.send(topic,empId,request);

    }

    public  void deleteEmployeeById(String empId){
        log.info("entered the delete employee service");
        this.deleteEmployeeByIdKafkaTemplate.send(deleteEmployeeTopic,empId);
    }
}
