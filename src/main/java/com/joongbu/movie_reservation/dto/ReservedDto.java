package com.joongbu.movie_reservation.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
| r_people | varchar(10) | NO   |     | NULL    |                |
| r_seats  | varchar(45) | NO   |     | NULL    |                |
| date     | date        | NO   |     | NULL    |                |
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
	private Date r_date;
	@Column(name = "r_cd")
	private String r_cd;
	@Column(name = "r_people")
	private String rPeople;
	@Column(name = "r_seats")
	private String rSeats;
	private Date date;
	
}
