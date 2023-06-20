package com.example.study_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StudyServletApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(StudyServletApplication.class, args);
	}
}
