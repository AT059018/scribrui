package io.ecx.scribr.converter;


import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import io.ecx.scribr.domain.SentenceModel;
import io.ecx.scribr.pojo.Sentence;

@Component("sentenceToSentenceModelConverter")
public class SentenceToSentenceModelConverter implements Converter<Sentence, SentenceModel> {

	@Override
	public SentenceModel convert(Sentence source) {
		SentenceModel model = new SentenceModel();
		model.setCreated(new Date());
		model.setSentence(source.getTranscript());
		
		model.setTask(StringUtils.containsIgnoreCase(source.getTranscript(), "please", Locale.ENGLISH));
		
		model.setSpeaker(source.getSpeaker());
		
		if(source.getSpeaker() != null) {
			if(source.getSpeaker() % 2 == 0) {
				model.setUsername("Tom");
			} else {
				model.setUsername("Victoria");
			}
		}
		return model;
	}


}
