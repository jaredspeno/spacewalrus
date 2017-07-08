package com.spacewalrus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spacewalrus.entities.Question;
import com.spacewalrus.repository.QuestionRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner seed(QuestionRepository repository) {
		return (args) -> {

			// Quesiton 1
			List<String> tags1 = new ArrayList<String>();
			tags1.add("best");
			tags1.add("java");
			tags1.add("question");

			Question question1 = new Question();
			question1.setTitle("stupid fucking question");
			question1.setContent("like umm.. here's my stupid quesiton or whatever");
			question1.setUserId("userX");
			question1.setTags(tags1);

			
			// Quesiton 2
			List<String> tags2 = new ArrayList<String>();
			tags2.add("worst");
			tags2.add("java");
			tags2.add("question");

			Question question2 = new Question();
			question2.setTitle("great question");
			question2.setContent("like umm.. here's my great quesiton or whatever");
			question2.setUserId("userY");
			question2.setTags(tags2);

			repository.save(question1);
			repository.save(question2);
			//
			//
			// // fetch all customers
			// log.info("Customers found with findAll():");
			// log.info("-------------------------------");
			// for (Customer customer : repository.findAll()) {
			// log.info(customer.toString());
			// }
			// log.info("");
			//
			// // fetch an individual customer by ID
			// Customer customer = repository.findOne(1L);
			// log.info("Customer found with findOne(1L):");
			// log.info("--------------------------------");
			// log.info(customer.toString());
			// log.info("");
			//
			// // fetch customers by last name
			// log.info("Customer found with findByLastName('Bauer'):");
			// log.info("--------------------------------------------");
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// log.info(bauer.toString());
			// }
			// log.info("");
		};
	}
}
