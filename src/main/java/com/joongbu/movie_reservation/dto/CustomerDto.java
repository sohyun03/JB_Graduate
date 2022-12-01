package com.joongbu.movie_reservation.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

/*
+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| c_no    | int         | NO   | PRI | NULL    | auto_increment |
| c_id    | varchar(45) | NO   |     | NULL    |                |
| c_pw    | varchar(45) | NO   |     | NULL    |                |
| c_name  | varchar(45) | NO   |     | NULL    |                |
| c_email | varchar(45) | NO   |     | NULL    |                |
+---------+-------------+------+-----+---------+----------------+
*/

@Data
@Entity
@Builder
@Table(name = "customer")
public class CustomerDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_no")
	private int cNo;
	
	
	@Column(name = "c_id")
	
	private String cId;
	@Column(name = "c_pw")
	private String cPw;
	@Column(name = "c_name")
	private String cName;
	@Column(name = "c_email")
	private String cEmail;
}
