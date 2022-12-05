package com.joongbu.movie_reservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joongbu.movie_reservation.dto.CustomerDto;
import com.joongbu.movie_reservation.repository.CustomerRepository;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/login.do")
	public void login() {

	}

	@ResponseBody
	@PostMapping("/idCheck")
	public boolean idCheck(CustomerDto customer) {
		// System.out.println(cId);
		boolean id = customerRepository.existsBycId(customer.getCId());

		return id;
	}
	
	@ResponseBody
	@PostMapping("/emailCheck")
	public void emailCheck(@Valid CustomerDto customer) {

	}

	@GetMapping("/register.do")
	public void register() {

	}
	
	// 회원가입버튼 누르면 오는 곳
	@PostMapping("/register")
	public String customerInfo(CustomerDto customer) {
		System.out.println(customer);
		customerRepository.save(customer);
		
		// redirect => post로 넘길때 새로고침시 중복 submit 방지
		return "redirect:/login/register.do";
	}
}
