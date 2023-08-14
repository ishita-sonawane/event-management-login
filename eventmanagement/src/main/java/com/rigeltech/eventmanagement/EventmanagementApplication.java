package com.rigeltech.eventmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan{name="come.rigeltech."}
@SpringBootApplication
public class EventmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
		System.out.println("running..");
	}

}
