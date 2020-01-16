package dev.fringe.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import dev.fringe.app.domain.Desserts;
import dev.fringe.app.service.DessertsService;

@Controller
public class HomeController {

	@Autowired RestTemplate restTemplate;
	@Autowired DessertsService dessertsService;
	
//	@RequestMapping("/")
//	public String home() {
//		System.out.println("If your project run Debug mode and change your application source, it is reload appliction source by dcevm.");
//		return "redirect:index.html"; 
//	}
//	
	@RequestMapping("/test")
	public String test() {
		System.out.println("ss");
		return "redirect:d.html"; 
	}
	
	
	@RequestMapping("/save")
	public String save() {
		dessertsService.save();
		return "redirect:d.html"; 
	}
	
	@RequestMapping("/save2")
	public void save2(@RequestBody Desserts desserts) {
		dessertsService.save(desserts);
	}
	@RequestMapping(value = "/desserts")
	public @ResponseBody Object get() {
		return dessertsService.get(); 
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
