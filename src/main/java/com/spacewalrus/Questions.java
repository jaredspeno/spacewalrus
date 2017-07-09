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

import com.spacewalrus.entities.Answer;
import com.spacewalrus.entities.Question;
import com.spacewalrus.repository.AnswerRepository;
import com.spacewalrus.repository.QuestionRepository;

@Controller
@Path("/questions")
public class Questions {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

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
		existingQuestion.setTags(question.getTags());
		existingQuestion.setAnswers(question.getAnswers());
		questionRepository.save(existingQuestion);

		return question;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/answers")
	public Answer addAnswerToQuestion(@PathParam("id") Long id, Answer answer) {

		Question existingQuestion = (Question) questionRepository.findOne(id);
		existingQuestion.getAnswers().add(answer);
		questionRepository.save(existingQuestion);

		// added so it would return id of answer to client... since id is not updated to
		// detached entity
		for (Answer a : existingQuestion.getAnswers()) {
			if (a.getContent().equals(answer.getContent()) && a.getUserId().equals(answer.getUserId())) {
				return a;
			}
		}

		return answer;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}/answers/{questionId}")
	public Answer updateAnswerToQuestion(@PathParam("id") Long id, @PathParam("questionId") Long questionId,
			Answer answer) {

		Answer existingAnswer = answerRepository.findOne(questionId);
		existingAnswer.setContent(answer.getContent());
		existingAnswer.setChosen(answer.isChosen());
		existingAnswer.setUserId(answer.getUserId());
		existingAnswer.setVoteCount(answer.getVoteCount());
		answer = answerRepository.save(existingAnswer);
		return answer;
	}

}
