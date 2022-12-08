package com.joongbu.movie_reservation.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/*
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| r_no     | int         | NO   | PRI | NULL    | auto_increment |
| c_no     | int         | NO   | MUL | NULL    |                |
| r_area   | varchar(5)  | NO   |     | NULL    |                |
| r_cinema | varchar(10) | NO   |     | NULL    |                |
| r_movie  | varchar(45) | NO   |     | NULL    |                |
| r_date   | date        | NO   |     | NULL    |                |
| r_cd     | varchar(10) | NO   |     | NULL    |                |
| adult    | int         | NO   |     | NULL    |                |
| teenager | int         | NO   |     | NULL    |                |
| soldier  | int         | NO   |     | NULL    |                |
| r_seats  | varchar(45) | NO   |     | NULL    |                |
| price    | int         | NO   |     | NULL    |                |
| date     | datetime    | NO   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
 */

@Data
@Entity
@Table(name = "reserved")
public class ReservedDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_no")
	private int rNo;

	@Column(name = "c_no")
	private int cNo;
	@Column(name = "r_area")
	private String rArea;
	@Column(name = "r_cinema")
	private String rCinema;
	@Column(name = "r_movie")
	private String rMovie;
	
	@Column(name = "r_date")
	private String rDate;
	@Column(name = "r_time")
	private String rTime;
	@Column(name = "r_cd")
	private String rCd;
	private int adult;
	private int teenager;
	private int soldier;
	@Column(name = "r_seats")
	private String rSeats;
	private int price;
	@CreatedDate
	private LocalDate date;
	//private Timestamp date;

}
