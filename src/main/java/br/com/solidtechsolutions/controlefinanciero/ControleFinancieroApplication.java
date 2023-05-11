package br.com.solidtechsolutions.controlefinanciero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class ControleFinancieroApplication {
	public static void main(String[] args) {
		SpringApplication.run(ControleFinancieroApplication.class, args);
	}

}
