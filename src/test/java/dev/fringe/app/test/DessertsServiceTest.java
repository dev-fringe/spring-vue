package dev.fringe.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import dev.fringe.app.service.DessertsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DessertsServiceTest {

	@Autowired DessertsService service;

	@Autowired RestTemplate restTemplate;
	
	@Test
	public void save() {
//		service.save();
		String data = restTemplate.getForObject("http://localhost:8081/desserts", String.class);
		System.out.println(data);
		
	}
}
