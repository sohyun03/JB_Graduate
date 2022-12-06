package com.joongbu.movie_reservation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
import com.joongbu.movie_reservation.dto.SeatDto;
import com.joongbu.movie_reservation.repository.AreaRepository;
import com.joongbu.movie_reservation.repository.CinemaRepository;
import com.joongbu.movie_reservation.repository.MovieListRepository;
import com.joongbu.movie_reservation.repository.SeatRepository;

@RequestMapping("/reservation")
@Controller
public class ReservationController {

	@Autowired
	AreaRepository areaRepository;

	@Autowired
	CinemaRepository cinemaRepository;

	@Autowired
	MovieListRepository movieListRepository;

	@Autowired
	SeatRepository seatRepository;

	@GetMapping("/reserve.do")
	public void rInser(Model model) {

		List<AreaDto> areaList = areaRepository.findAll();
		// List<MovieListDto> mlList = movieListRepository.findAll();
		model.addAttribute("areaList", areaList);
		// model.addAttribute("mlList", mlList);

		List<String> dateList = new ArrayList<>(10);

		Calendar cal = Calendar.getInstance();
		String format = "dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		// 오늘날짜
		String date = sdf.format(cal.getTime());
		// 오늘요일
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
		dateList.add(korDayOfWeek + " " + date);

		// 오늘로부터 9일동안 데이터 가져오기
		Calendar day1 = Calendar.getInstance();

		for (int i = 0; i < 9; i++) {
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
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("dateList", dateList);
	}

	// 지역 입력받아서 세부지역 뿌려주기
	@ResponseBody // ajax로 받으려면 ResponseBody를 써야함
	@PostMapping("/option")
	public List<CinemaDto> option(@RequestParam("aNo") int aNo, HttpSession session) {

		List<CinemaDto> cList = cinemaRepository.findByarea(aNo);

		// System.out.println(cList);
		// model.addAttribute("cList", cList);
		session.setAttribute("cList", cList);

		return cList;
	}

	// 세부지역 받아서 그에 맞는 영화 불러오기
	@ResponseBody
	@PostMapping("/option2")
	public void option2(@RequestParam("ciNo") int ciNo, HttpSession session) {

		List<MovieListDto> mList = movieListRepository.findAll(ciNo);
		// System.out.println(mList);
		session.setAttribute("mList", mList);
	}

	// 선택한 포스터 가져오기
	@ResponseBody
	@PostMapping("/poster")
	public String poster(@RequestParam("mlName") String name, HttpSession session) {

		String imgurl = movieListRepository.findByimgurl(name);
		// System.out.println(imgurl);

		return imgurl;
	}

	// reserve에서 seat으로 data(session) 전송
	@ResponseBody
	@PostMapping("/reserve")
	public void reserve(HttpSession session, ReservedDto rDto) {

		session.setAttribute("rSession", rDto);

	}

	/*************************** 좌석 선택 ***************************/

	@GetMapping("/seat.do")
	public void seat(Model model) {

		// System.out.println(rSession);
		List<SeatDto> sList = seatRepository.findAll();

		model.addAttribute("sList", sList);

	}

	@ResponseBody
	@PostMapping("/seats")
	public void getSeats(ReservedDto rDto, @SessionAttribute ReservedDto rSession) {

		rSession.setAdult(rDto.getAdult());
		rSession.setTeenager(rDto.getTeenager());
		rSession.setSoldier(rDto.getSoldier());
		rSession.setRSeats(rDto.getRSeats());
		rSession.setPrice(rDto.getPrice());

	}

	/*************************** 결제 ***************************/

	@GetMapping("/payment.do")
	public void payment(Model model, @SessionAttribute ReservedDto rSession) {
		System.out.println(rSession);

		Optional<MovieListDto> movieList = movieListRepository.selectByUserIdAndPw(rSession.getRMovie());
		// System.out.println(movieList);
		model.addAttribute("movieList", movieList.get());
	}

	/*************************** 결제 완료 ***************************/

	@GetMapping("/complete.do")
	public void complete(Model model, @SessionAttribute(required = false) ReservedDto rSession) {
		
		if(rSession == null) {
			System.out.println("없음");
		}
		model.addAttribute("reserved", rSession);
	}
}
