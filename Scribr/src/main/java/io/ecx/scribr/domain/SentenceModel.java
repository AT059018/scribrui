package io.ecx.scribr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.apache.commons.lang3.StringUtils;


@Entity
public class SentenceModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Date created;
	
	@NotNull
	private String sentence;
	
	private Integer speaker;
	
	@NotNull
	private Boolean task;
	
	private String username;
	
	public SentenceModel() {
		super();
	}

	public SentenceModel(Date created, String sentence, Integer speaker) {
		this.created = created;
		this.sentence = sentence;
		this.speaker = speaker;
		this.task = Boolean.FALSE;
		this.username = StringUtils.EMPTY;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public Integer getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Integer speaker) {
		this.speaker = speaker;
	}

	public Boolean getTask() {
		return task;
	}

	public void setTask(Boolean task) {
		this.task = task;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SentenceModel [id=" + id + ", created=" + created + ", sentence=" + sentence + ", speaker=" + speaker
				+ "]";
	}
	
	
}
