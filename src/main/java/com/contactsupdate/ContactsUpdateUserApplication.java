package com.contactsupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Shagun Bakliwal
 *
 */
@SpringBootApplication
@EnableSwagger2
public class ContactsUpdateUserApplication {

	/**
	 * @param args no var-ags needed
	 */
	public static void main(String[] args) {
		SpringApplication.run(ContactsUpdateUserApplication.class, args);
	}
}
