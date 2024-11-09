package br.edu.infnet.AppMoisesAndrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppMoisesAndradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMoisesAndradeApplication.class, args);

;	}
}
