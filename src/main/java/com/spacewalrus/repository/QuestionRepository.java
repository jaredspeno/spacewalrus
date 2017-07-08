package com.spacewalrus.repository;

import org.springframework.data.repository.CrudRepository;

import com.spacewalrus.entities.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

//	List<Question> findById(int id);
}
