package com.spacewalrus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spacewalrus.entities.Question;
import com.spacewalrus.entities.Tag;
import com.spacewalrus.repository.QuestionRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner seed(QuestionRepository repository) {
		return (args) -> {
			
//			List<Tag> tags = new ArrayList<Tag>();
//			List<Tag> tags2 = new ArrayList<Tag>();
//			
//			Tag tag1 = new Tag();
//			tag1.setTag("stupid-quesiton");
//			tags.add(tag1);
//			
//			Tag tag2 = new Tag();
//			tag1.setTag("great-question");
//			
//			tags.add(tag1);
//			tags2.add(tag2);

			Question question1 = new Question();
			question1.setTitle("stupid fucking question");
			question1.setContent("like umm.. here's my stupid quesiton or whatever");
//			question1.setQuestionId(1L);
			question1.setUserId("userX");
//			question1.setTags(tags);

			Question question2 = new Question();
			question2.setTitle("great question");
			question2.setContent("like umm.. here's my great quesiton or whatever");
//			question2.setQuestionId(2L);
			question2.setUserId("userY");
//			question2.setTags(tags2);

			repository.save(question1);
			repository.save(question2);
//			
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findOne(1L);
//			log.info("Customer found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (Customer bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
		};
	}
}
