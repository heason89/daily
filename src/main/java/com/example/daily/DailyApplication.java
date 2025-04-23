package com.example.daily;

import com.example.daily.env.EnvLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.Map;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DailyApplication {

	public static void main(String[] args) {
		Map<String, String> env = EnvLoader.loadEnv(".env");
		System.setProperty("SMTP_HOST", env.get("SMTP_HOST"));
		System.setProperty("SMTP_USER", env.get("SMTP_USER"));
		System.setProperty("SMTP_PASS", env.get("SMTP_PASS"));
		SpringApplication.run(DailyApplication.class, args);
	}

}
