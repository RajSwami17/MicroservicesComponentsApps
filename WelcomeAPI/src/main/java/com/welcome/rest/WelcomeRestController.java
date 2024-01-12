package com.welcome.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.welcome.client.GreetApiClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetApiClient greetApiClient;
	
	private Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);
	
	@GetMapping("/welcome/{name}")
	public String welcomeMessage(@PathVariable("name")String name)
	{
		logger.info("welcomeMessage() Execution - Start");
		String welcomeMsg = "Welcome To My First MicroServices App..!!";
		String greetMsg = greetApiClient.invokeGreetApi(name);
		logger.info("welcomeMessage() Execution - End");
		return greetMsg + ", " + welcomeMsg ; 
		
		//RestTemplate rt = new RestTemplate();
		//rt.getForEntity("http://localhost:9090/greet",String.class);
	}
}

