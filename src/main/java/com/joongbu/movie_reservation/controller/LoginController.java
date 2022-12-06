package com.joongbu.movie_reservation.controller;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joongbu.movie_reservation.dto.CustomerDto;
import com.joongbu.movie_reservation.repository.CustomerRepository;
import com.joongbu.movie_reservation.service.UserService;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;

	private UserService userService;

	@GetMapping("/login.do")
	public void login() {

	}

	@ResponseBody
	@PostMapping("/login")
	public int log(@RequestParam("id") String id, @RequestParam("pw") String pw, HttpSession session) {

		int msg; // 0: 성공, 1: 아이디없음, 2: 비밀번호 틀림

		Optional<CustomerDto> loginId = null;
		Optional<CustomerDto> loginUser = null;
		try {
			loginId = customerRepository.findBycId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (loginId.isEmpty()) {
			msg = 1;
			return msg;
		} else {
			loginUser = customerRepository.findBycIdAndPw(id, pw);
			if (loginUser.isEmpty()) {
				msg = 2;
				return msg;
			} else {
				msg = 0;
				session.setAttribute("loginUser", loginUser.get());
				return msg;
			}
		}

	}

	@ResponseBody
	@PostMapping("/idCheck")
	public boolean idCheck(CustomerDto customer) {

		boolean id = customerRepository.existsBycId(customer.getCId());

		return id;
	}

	@ResponseBody
	@PostMapping("/emailCheck")
	public void emailCheck(@Valid CustomerDto customer, BindingResult errors, Model model) {

		if (errors.hasErrors()) {
			Map<String, String> validatorResult = userService.validateHandling(errors);
			for (String key : validatorResult.keySet()) {
				model.addAttribute(key, validatorResult.get(key));
			}
		}
	}

	@GetMapping("/register.do")
	public void register() {

	}

	// 회원가입버튼 누르면 오는 곳
	@ResponseBody
	@PostMapping("/register")
	public int customerInfo(CustomerDto customer) {
		System.out.println(customer);
		customerRepository.save(customer);

		// redirect => post로 넘길때 새로고침시 중복 submit 방지
		return 0;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// session.invalidate();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
}
