package com.ibm.kafka.springbootproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SpringBootProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class, args);
		log.info("******************************************************");
		log.info("_________________Application Started__________________");
		log.info("******************************************************");

	}


}
