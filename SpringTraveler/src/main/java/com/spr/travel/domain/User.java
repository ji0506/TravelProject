package com.spr.travel.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name ="user")
public class User {

	@Id
	private String userId; //아이디

	private String userPwd; //비밀번호

	private String userName; //이름

	private String userGender; //성별

	private String userBirth; //생년월일

	private String userEmail; //이메일

	private String userCp; //핸드폰번호

	private String userAddr; //주소

	private String userDaddr; //상세주소

	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	private String userGrade;

	private String userTypeCd;
}

