package io.ecx.scribr.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.ecx.scribr.converter.SentenceToSentenceModelConverter;
import io.ecx.scribr.domain.SentenceModel;
import io.ecx.scribr.pojo.JsonReponse;
import io.ecx.scribr.pojo.Sentence;
import io.ecx.scribr.repository.SentenceRepository;


@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	private String title = "Scribr.";
	
	@Autowired
	private SentenceToSentenceModelConverter sentenceToSentenceModelConverter;
	
	@Autowired
	private SentenceRepository sentenceRepository;
	
	@Autowired
    private SimpMessagingTemplate template;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("title", title);
		model.addAttribute("entries", sentenceRepository.findAll());
		return "index";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(path = "/api/add.json", method=RequestMethod.POST)
	public ResponseEntity<JsonReponse> add(@RequestBody Sentence sentence) throws Exception {
		final SentenceModel model = sentenceToSentenceModelConverter.convert(sentence);
		sentenceRepository.save(model);
		template.convertAndSend("/topic/sentence", model);
		LOG.info(model.toString());
		return new ResponseEntity<JsonReponse>(new JsonReponse(true),HttpStatus.OK);
	}

}
