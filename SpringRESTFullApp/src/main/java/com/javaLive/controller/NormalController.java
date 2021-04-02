package com.javaLive.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaLive.model.User;
import com.javaLive.service.UserService;

@Controller
@RequestMapping("/user")
public class NormalController {
	public static final Logger logger = LoggerFactory.getLogger(RESTController.class);

	@Autowired
	UserService userService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All
	// Users---------------------------------------------

	@RequestMapping("/getlist")
	public String listEmployees(ModelMap model) {
		
		List<User> users = userService.findAllUsers();
		model.addAttribute("employees", users);
		return "alluserss";
	}

	
	@RequestMapping(value="/getuser/{name}")
	public String getUser(@PathVariable String name,ModelMap model) {
		User user = userService.findByName(name);
		if (user == null) {
			//logger.error("User with id {} not found.", id);
			System.out.println("User not found");
		}
		model.addAttribute("user", user);
		return "userInfo";
	}
}
