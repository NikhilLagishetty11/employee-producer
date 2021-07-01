package com.ibm.kafka.springbootproducer.requestDTO;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeByIdRequest {

    private String empId;
}
