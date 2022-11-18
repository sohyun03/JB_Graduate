package com.joongbu.movie_reservation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

		List<String> dateList = new ArrayList<>(15);
		
		Calendar cal = Calendar.getInstance();
		String format = "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(cal.getTime());
		int day = cal.get(Calendar.DAY_OF_WEEK);
		String korDayOfWeek = "";
		switch (day) {
		    case 1:
		        korDayOfWeek = "일";
		        break;
		    case 2:
		        korDayOfWeek = "월";
		        break;
		    case 3:
		        korDayOfWeek = "화";
		        break;
		    case 4:
		        korDayOfWeek = "수";
		        break;
		    case 5:
		        korDayOfWeek = "목";
		        break;
		    case 6:
		        korDayOfWeek = "금";
		        break;
		    case 7:
		        korDayOfWeek = "토";
		        break;
		}
		// System.out.println(korDayOfWeek);
		dateList.add(korDayOfWeek + " " + date);

		Calendar day1 = Calendar.getInstance();

		for (int i = 0; i < 14; i++) {
			day1.add(Calendar.DATE, +1);
			String dayDate = new java.text.SimpleDateFormat("dd").format(day1.getTime());
			
			int days = day1.get(Calendar.DAY_OF_WEEK);
			String kor = "";
			switch (days) {
			    case 1:
			    	kor = "일";
			        break;
			    case 2:
			    	kor = "월";
			        break;
			    case 3:
			    	kor = "화";
			        break;
			    case 4:
			    	kor = "수";
			        break;
			    case 5:
			    	kor = "목";
			        break;
			    case 6:
			    	kor = "금";
			        break;
			    case 7:
			    	kor = "토";
			        break;
			}
			dateList.add(kor + " " + dayDate);
			// System.out.println(kor);
		}
		model.addAttribute("dateList", dateList);
	}

	@ResponseBody // ajax로 받으려면 ResponseBody를 써야함
	@PostMapping("/option")
	public List<CinemaDto> option(@RequestParam("aNo") int aNo, Model model, HttpSession session) {

		List<CinemaDto> cList = cinemaRepository.findByarea(aNo);

		// System.out.println(cList);
		// model.addAttribute("cList", cList);
		session.setAttribute("cList", cList);

		return cList;
	}

	@ResponseBody
	@PostMapping("/poster")
	public String poster(@RequestParam("mlName") String name, HttpSession session) {

		String imgurl = movieListRepository.findByimgurl(name);
		// System.out.println(imgurl);

		return imgurl;
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
