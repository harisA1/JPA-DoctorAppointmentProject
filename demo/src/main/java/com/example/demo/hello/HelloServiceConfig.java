package com.example.demo.hello;

import org.springframework.boot.*;
import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Configuration
public class HelloServiceConfig implements CommandLineRunner {
	
	@Autowired
	private HelloService hs;
	
	@Override
	public void run(String... args) throws Exception {

		/**
		 * In case you want your server to load data at startup it must be done the following way!
		 * In that case in application.properties: 
		 *                spring.jpa.hibernate.ddl-auto=create
		 * which will first drop the existing tables and create new ones it could be
		*/
		
		/*
		hs.addStudent(new Student("Apostolis",43,"Thessaloniki"));
		hs.addStudent(new Student("Alex",48,"Thessaloniki"));
		hs.addStudent(new Student("Daniel",35,"Groningen"));
		*/

		
		/**
		 * In our case: 
		 * 		spring.jpa.hibernate.ddl-auto=update
		 * to sync the data from the DB on startup
 		 */
	}

}
