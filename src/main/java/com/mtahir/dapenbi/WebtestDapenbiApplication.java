package com.mtahir.dapenbi;

import com.mtahir.dapenbi.utilities.FileCsvUtility;
import com.mtahir.dapenbi.utilities.FileTxtUtility;
import com.mtahir.dapenbi.utilities.ValidationUtility;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebtestDapenbiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebtestDapenbiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public FileCsvUtility fileCsvUtility() {
		return new FileCsvUtility();
	}

	@Bean
	public FileTxtUtility fileTxtUtility() {
		return new FileTxtUtility();
	}

	@Bean
	public ValidationUtility validationUtility() {
		return new ValidationUtility();
	}

}
