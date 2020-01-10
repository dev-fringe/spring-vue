package dev.fringe.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	@Autowired RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("sdsd");
		return "redirect:index.html"; 
	}
	
	@Scheduled(fixedRateString = "60000", initialDelay = 30000) 
	private void scheduleTest() {
		String data  = "";
	    String webPort = System.getenv("PORT");
	    if(webPort == null || webPort.isEmpty()) {
	        webPort = "8080";
	    }else {
	    	data = restTemplate.getForObject("https://dev-fringe.herokuapp.com/index.html", String.class);
	    	System.out.println("webPort = "  + webPort + ", data = " + data);
	    }
	}
}
