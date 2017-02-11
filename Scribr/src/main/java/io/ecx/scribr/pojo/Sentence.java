package io.ecx.scribr.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class Sentence {
	@NotNull
	private String transcript;
	
	@Null
	private Integer speaker;
	
	public Sentence() {
		super();
	}

	public Sentence(String transcript, Integer speaker) {
		super();
		this.transcript = transcript;
		this.speaker = speaker;
	}

	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public Integer getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Integer speaker) {
		this.speaker = speaker;
	}

	@Override
	public String toString() {
		return "Sentence [transcript=" + transcript + ", speaker=" + speaker + "]";
	}
	
}
