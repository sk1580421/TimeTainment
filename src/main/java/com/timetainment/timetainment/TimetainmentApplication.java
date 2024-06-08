package com.timetainment.timetainment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan("com.timetainment.timetainment.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class TimetainmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimetainmentApplication.class, args);

	}

}
