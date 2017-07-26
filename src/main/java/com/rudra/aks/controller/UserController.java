package com.rudra.aks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rudra.aks.bo.TestBO;
import com.rudra.aks.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService		userService;
	
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public ResponseEntity<?>	saveUser(@RequestBody TestBO testBO) {
		return new ResponseEntity<>(userService.saveUser(testBO), HttpStatus.OK);
	}
	
	
	@RequestMapping(path = "/")
	public String hello() {
		return "<h1> Hello </h1>";
	}
}
