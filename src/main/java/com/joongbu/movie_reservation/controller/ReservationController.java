package com.joongbu.movie_reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joongbu.movie_reservation.dto.AreaDto;
import com.joongbu.movie_reservation.dto.CinemaDto;
import com.joongbu.movie_reservation.repository.AreaRepository;
import com.joongbu.movie_reservation.repository.CinemaRepository;

@RequestMapping("/reservation")
@Controller
public class ReservationController {
	
	@Autowired
	AreaRepository areaRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;

	@GetMapping("/reserve.do")
	public void rInser(Model model) {
		
		List<AreaDto> areaList = areaRepository.findAll();
		
		model.addAttribute("areaList", areaList);
		
	}
	
	@ResponseBody // ajax로 받으려면 ResponseBody를 써야함
	@PostMapping("/option")
	public void option(@RequestParam("aNo") int aNo, Model model){
		
		// System.out.println(aNo);
		
		CinemaDto cList = cinemaRepository.findByarea(aNo);
		
		System.out.println(cList);
		
//		if(aNo == cList.getArea().getANo()) {
//			
//			model.addAttribute("cList", cList);
//		}
		
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
