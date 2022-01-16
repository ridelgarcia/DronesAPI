package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/main")
public class MainController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	public String index() {
		return "Greetings from Spring Boot!";
	}

}