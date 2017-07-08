package com.spacewalrus.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	
	private String title;
	private String content;
	private String userId;
	
//	@OneToMany(mappedBy="tagId")
//	private List<Tag> tags;
	
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
//	public List<Tag> getTags() {
//		return tags;
//	}
//	public void setTags(List<Tag> tags) {
//		this.tags = tags;
//	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
