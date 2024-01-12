package com.greet.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	private Logger logger = LoggerFactory.getLogger(GreetRestController.class);
	
	@Autowired
	private Environment environmanet;
	
	@GetMapping("/greet{name}")
	public String greetMessage(@PathVariable("name")String name)
	{
		logger.info("greetMessage() execution - start");
		
		String port = environmanet.getProperty("server.port");
		
		String msg = name + ", Good Morning..!!(Server Port :: " + port + ")";
		
		logger.info("greetMessage() execution - end");
		
		return msg;
	}
	
}
