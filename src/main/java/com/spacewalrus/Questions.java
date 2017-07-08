package com.spacewalrus;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spacewalrus.entities.Question;
import com.spacewalrus.entities.Tag;
import com.spacewalrus.repository.QuestionRepository;

@Controller
@Path("/questions")
public class Questions {

	@Autowired
	private QuestionRepository questionRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getAllQuestions() {
//		List<Question> questions = defaultData();

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
		
//		Question question = findByIdHardcoded(id);
		Question question = (Question) questionRepository.findOne(id);

		return question;
	}

	private Question findByIdHardcoded(Long id) {
		System.out.println("finding quesiton by id: " + id);
		
		Question question = new Question();

		List<Tag> tags = new ArrayList<Tag>();
		Tag tag1 = new Tag();
		tag1.setTag("stupid-quesiton");
		tags.add(tag1);

		if (id == 1) {
			Question question1 = new Question();
			question1.setTitle("stupid fucking question");
			question1.setContent("like umm.. here's my stupid quesiton or whatever");
			question1.setQuestionId(1L);
			question1.setUserId("userX");
//			question1.setTags(tags);
			question = question1;
		} else if (id == 2) {
			Question question2 = new Question();
			question2.setTitle("great question");
			question2.setContent("like umm.. here's my great quesiton or whatever");
			question2.setQuestionId(2L);
			question2.setUserId("userY");
//			question2.setTags(tags);
			question = question2;
		} else {
			question = new Question();
		}
		return question;
	}

	private ArrayList<Question> defaultData() {
		List<Tag> tags = new ArrayList<Tag>();
		Tag tag1 = new Tag();
		tag1.setTag("stupid-quesiton");
		tags.add(tag1);

		ArrayList<Question> questions = new ArrayList<Question>();

		Question question1 = new Question();
		question1.setTitle("stupid fucking question");
		question1.setContent("like umm.. here's my stupid quesiton or whatever");
		question1.setQuestionId(1L);
		question1.setUserId("userX");
//		question1.setTags(tags);

		Question question2 = new Question();
		question2.setTitle("great question");
		question2.setContent("like umm.. here's my great quesiton or whatever");
		question2.setQuestionId(2L);
		question2.setUserId("userY");
//		question2.setTags(tags);

		questions.add(question1);
		questions.add(question2);
		return questions;
	}

}
