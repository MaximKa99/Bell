package com.bell.myproject;

import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MyprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

	@Bean
	public CriteriaBuilder criteriaBuilder(EntityManager em) {
		return em.getCriteriaBuilder();
	}

	// @Bean
    // public TaskExecutor controllerPool() {
    //     ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    //     executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() + 1);
    //     executor.setQueueCapacity(25);
    //     return executor;
    // }

    // @Bean
    // public LocaleResolver localeResolver() {
    //     SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    //     sessionLocaleResolver.setDefaultLocale(Locale.US);
    //     return sessionLocaleResolver;
    // }
}
