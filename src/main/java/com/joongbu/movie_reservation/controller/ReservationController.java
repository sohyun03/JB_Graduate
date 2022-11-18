package com.joongbu.movie_reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.joongbu.movie_reservation.dto.AreaDto;
import com.joongbu.movie_reservation.dto.CinemaDto;
import com.joongbu.movie_reservation.dto.MovieListDto;
import com.joongbu.movie_reservation.dto.ReservedDto;
import com.joongbu.movie_reservation.repository.AreaRepository;
import com.joongbu.movie_reservation.repository.CinemaRepository;
import com.joongbu.movie_reservation.repository.MovieListRepository;

@RequestMapping("/reservation")
@Controller
public class ReservationController {

	@Autowired
	AreaRepository areaRepository;

	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	MovieListRepository movieListRepository;

	@GetMapping("/reserve.do")
	public void rInser(Model model) {

		List<AreaDto> areaList = areaRepository.findAll();
		List<MovieListDto> mlList = movieListRepository.findAll();
		model.addAttribute("areaList", areaList);
		model.addAttribute("mlList", mlList);
	}

	@ResponseBody // ajax로 받으려면 ResponseBody를 써야함
	@PostMapping("/option")
	public List<CinemaDto> option(@RequestParam("aNo") int aNo, Model model, HttpSession session) {

		// System.out.println(aNo);

		List<CinemaDto> cList = cinemaRepository.findByarea(aNo);

		// System.out.println(cList);
		// model.addAttribute("cList", cList);
		session.setAttribute("cList", cList);
		
		return cList;

	}


	@PostMapping("/reserve")
	public String reserve(HttpSession session, ReservedDto rDto) {
		
		session.setAttribute("rSession", rDto);
		
		
		return "redirect:/reservation/seat.do";
	}

	@GetMapping("/seat.do")
	public void h(@SessionAttribute ReservedDto rSession) {
		System.out.println(rSession);
	}

	@GetMapping("/payment.do")
	public void a() {

	}
}
