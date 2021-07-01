package com.ibm.kafka.springbootproducer.requestDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeDetailsRequest {

    private String empId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

}
