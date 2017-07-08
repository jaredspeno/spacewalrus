package com.spacewalrus.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;

	private String title;
	private String content;
	private String userId;

	@ElementCollection(fetch=FetchType.EAGER)
	@Column(name="tags")
//	@CollectionTable(name = "TAG", joinColumns = @JoinColumn(name = "TAG_ID"))
	private List<String> tags;

	// @OneToMany(mappedBy="tagId")
	// private List<Tag> tags;


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

	// public List<Tag> getTags() {
	// return tags;
	// }
	// public void setTags(List<Tag> tags) {
	// this.tags = tags;
	// }
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
