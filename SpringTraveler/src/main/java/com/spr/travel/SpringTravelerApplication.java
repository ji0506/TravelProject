package com.spr.travel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spr.travel.dao")
public class SpringTravelerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTravelerApplication.class, args);
	}

}
