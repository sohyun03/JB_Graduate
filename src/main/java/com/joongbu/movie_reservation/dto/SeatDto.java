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
+----------+------------+------+-----+---------+----------------+
| Field    | Type       | Null | Key | Default | Extra          |
+----------+------------+------+-----+---------+----------------+
| s_no     | int        | NO   | PRI | NULL    | auto_increment |
| s_name   | varchar(3) | YES  |     | NULL    |                |
| cd_no    | int        | YES  |     | NULL    |                |
| reserved | tinyint    | YES  |     | 0       |                |
+----------+------------+------+-----+---------+----------------+
 */

@Data
@Entity
@Table(name = "seat")
public class SeatDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_no")
	private int sNo;
	
	@Column(name = "s_name")
	private String sName;
	@Column(name = "cd_no")
	private int cdNo;
	
	private int reserved;
}
