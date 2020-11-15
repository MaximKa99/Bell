package com.bell.myproject;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyprojectApplication {

	//TODO доделать маппер
	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

	@Bean
	public CriteriaBuilder criteriaBuilder(EntityManager em) {
		return em.getCriteriaBuilder();
	}
}
