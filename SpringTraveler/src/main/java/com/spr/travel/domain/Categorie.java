package com.spr.travel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Categorie")
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
@Data
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kateNo;
	
	
	private String kateName;
	
	private String userTypeCd;
	
	private String kateDetail;
}