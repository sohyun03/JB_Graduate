package com.joongbu.movie_reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joongbu.movie_reservation.dto.AreaDto;
import com.joongbu.movie_reservation.repository.AreaRepository;

@RequestMapping("/reservation")
@Controller
public class ReservationController {
	
	@Autowired
	AreaRepository areaRepository;

	@GetMapping("/reserve.do")
	public void rInser(Model model) {
		
		List<AreaDto> areaList = areaRepository.findAll();
		
		model.addAttribute("areaList", areaList);
	}
	
	@PostMapping("/reserve")
	public String reserve() {
		
		
		return "redirect:/reservation/seat.do";
	}

	@GetMapping("/seat.do")
	public void h() {

	}

	@GetMapping("/payment.do")
	public void a() {

	}
}
