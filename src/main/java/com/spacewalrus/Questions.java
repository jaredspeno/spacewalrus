package com.spacewalrus;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spacewalrus.entities.Question;
import com.spacewalrus.repository.QuestionRepository;

@Controller
@Path("/questions")
public class Questions {

	@Autowired
	private QuestionRepository questionRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getAllQuestions() {
		List<Question> questions = (List<Question>) questionRepository.findAll();
		return questions;
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Question createQuestion(Question question) {

		questionRepository.save(question);

		return question;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Question getQuestionById(@PathParam("id") Long id) {
		
		Question question = (Question) questionRepository.findOne(id);
		
		return question;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Question updateQuestionById(@PathParam("id") Long id, Question question) {
		
		Question existingQuestion = (Question) questionRepository.findOne(id);
		existingQuestion.setContent(question.getContent());
		existingQuestion.setTitle(question.getTitle());
		existingQuestion.setUserId(question.getUserId());
		questionRepository.save(existingQuestion);
		
		return question;
	}
}
