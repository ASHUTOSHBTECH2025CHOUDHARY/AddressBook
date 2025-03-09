package com.AddressBook.Address;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AddressApplication {
	public static void main(String[] args) {
		log.info("Starting Address Book Application...");
		SpringApplication.run(AddressApplication.class, args);
		log.info("Address Book Application Started Successfully.");
	}
}
