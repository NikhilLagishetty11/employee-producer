package com.ibm.kafka.springbootproducer.cofiguration;



import com.ibm.kafka.springbootproducer.requestDTO.Employee;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Employee> producerFactory(){
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);  //
//        config.put(JsonSerializer.TYPE_MAPPINGS, "employee:com.ibm.kafka.springbootproducer.requestDTO.Employee");//
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String,Employee> kafkaTemplate(){
        return  new KafkaTemplate<>(producerFactory());
    }


    @Bean
    public ProducerFactory<String, String> updateProducerFactory(){
        Map<String, Object> deleteEmployeeConfig = new HashMap<>();

        deleteEmployeeConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        deleteEmployeeConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        deleteEmployeeConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(deleteEmployeeConfig);
    }

    @Bean
    public KafkaTemplate<String,String> updateKafkaTemplate(){
        return  new KafkaTemplate<>(updateProducerFactory());
    }

}
