package com.ibm.kafka.springbootproducer.requestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
