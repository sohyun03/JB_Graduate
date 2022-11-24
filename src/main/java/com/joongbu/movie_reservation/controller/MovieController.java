package com.joongbu.movie_reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.joongbu.movie_reservation.dto.MovieListDto;
import com.joongbu.movie_reservation.repository.MovieListRepository;

@Controller
public class MovieController {
	
	@Autowired
	MovieListRepository movieListRepository;
	
	@GetMapping("/")
	public String top10(Model model) {
		List<MovieListDto> topList = movieListRepository.findTop10ByOrderByMlRateDesc();
		
		//System.out.println(topList);
		model.addAttribute("topList", topList);
		
		return "index.html";
	}
	
	@GetMapping("/movie.do")
	public void showMovie(Model model) {
		
		List<MovieListDto> mlList = movieListRepository.findAll();
		model.addAttribute("mlList", mlList);
	}
	
	@GetMapping("/recommend.do")
	public void reco() {
		
	}
}
