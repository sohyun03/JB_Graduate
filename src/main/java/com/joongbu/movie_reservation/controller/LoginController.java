package com.joongbu.movie_reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joongbu.movie_reservation.dto.CustomerDto;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	
	@GetMapping("/login.do")
	public void login() {
		
	}
	
	@ResponseBody
	@PostMapping("/idCheck")
	public void idCheck(CustomerDto customer) {
		System.out.println(customer);
	}
	
	@GetMapping("/register.do")
	public void register() {
		
	}
}
