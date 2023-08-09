package com.spr.travel.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the boards database table.
 * 
 */
@Entity
@Data
public class Qna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=11)
	private int qnaNo;

	@Column(length=40)
	private String qnaTitle;

	@Lob
	private String qnaContent;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Column(length=11)
	private String userId;

	@Column(length=5)
	private int cnt;

	
}