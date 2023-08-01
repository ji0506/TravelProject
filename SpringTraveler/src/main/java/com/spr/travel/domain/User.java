package com.spr.travel.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private String userId;

	private String userPwd;

	private String userName;
	
	private String userEmail;

	private String userCp;

	private String userAddr;

	private String userDaddr;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	private String userGrade;
	
	private String userTypeCd;

	
	
}
