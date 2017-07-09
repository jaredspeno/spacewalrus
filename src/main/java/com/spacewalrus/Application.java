package com.spacewalrus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spacewalrus.entities.Answer;
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

			// Question 1
			List<String> tags1 = new ArrayList<String>();
			tags1.add("best");
			tags1.add("java");
			tags1.add("question");
			
			Answer answer1 = new Answer();
			answer1.setChosen(true);
			answer1.setContent("dude totes the answer");
			answer1.setUserId("adsmin");
			answer1.setVoteCount(1);
			
			Answer answer2 = new Answer();
			answer2.setChosen(false);
			answer2.setContent("bro totes the answerrrrr");
			answer2.setUserId("adsmin");
			answer2.setVoteCount(1);
			
			List<Answer> answers = new ArrayList<Answer>();
			answers.add(answer1);
			answers.add(answer2);

			Question question1 = new Question();
			question1.setTitle("stupid question dude");
			question1.setContent("like umm.. here's my stupid quesiton or whatever");
			question1.setUserId("stupid-user");
			question1.setTags(tags1);
			question1.setAnswers(answers);

			// Question 2
			List<String> tags2 = new ArrayList<String>();
			tags2.add("worst");
			tags2.add("java");
			tags2.add("question");

			Answer answer3 = new Answer();
			answer3.setChosen(false);
			answer3.setContent("dude totes probs the answer");
			answer3.setUserId("asssss");
			answer3.setVoteCount(1);
			
			Answer answer4 = new Answer();
			answer4.setChosen(true);
			answer4.setContent("broseph totes the anzer");
			answer4.setUserId("asdf");
			answer4.setVoteCount(1);
			
			List<Answer> answers2 = new ArrayList<Answer>();
			answers2.add(answer3);
			answers2.add(answer4);
			
			Question question2 = new Question();
			question2.setTitle("great question friend");
			question2.setContent("like umm.. here's my great quesiton or whatever");
			question2.setUserId("great-user");
			question2.setTags(tags2);
			question2.setAnswers(answers2);

			repository.save(question1);
			repository.save(question2);
		};
	}
}
