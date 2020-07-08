package com.example.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.Student;

import brave.sampler.Sampler;

@RestController
@SpringBootApplication
public class StudentDetailsApplication {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/StudentName/{name}")
	public String echoStudentName(@PathVariable(name = "name") String name) {
		logger.info("{}", name);
		return "hello " + name + " Responsed on : " + new Date();
	}

	@RequestMapping(value = "/getStudentDetails/{name}")
	public Student getStudentDetails(@PathVariable(name = "name") String name) {
		logger.info("{get mapping}", name);
		return new Student(name, "Jaipur", "B.tech");
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentDetailsApplication.class, args);
	}

	@Bean
	public Sampler defualtSampler() {
		return Sampler.ALWAYS_SAMPLE;

	}
}
