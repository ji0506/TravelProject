package com.spr.travel.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="product_detail")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int detailNo;

	private int proNo;

	private String detailInfo;
	
	private String detailImage;

	private String schedule;
	
	private String detailViewcnt;

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public String getDetailImage() {
		return detailImage;
	}

	public void setDetailImage(String detailImage) {
		this.detailImage = detailImage;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDetailViewcnt() {
		return detailViewcnt;
	}

	public void setDetailViewcnt(String detailViewcnt) {
		this.detailViewcnt = detailViewcnt;
	}
}
