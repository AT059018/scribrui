package io.ecx.scribr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.ecx.scribr.service.JiraRestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScribrApplicationTests {
	
	@Autowired
	private JiraRestClient client;

	@Test
	public void contextLoads() {
		
		client.send("TitleTest2", "Super Text!!!");
		
	}

}
