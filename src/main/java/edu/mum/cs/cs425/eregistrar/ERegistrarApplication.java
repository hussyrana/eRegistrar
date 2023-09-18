package edu.mum.cs.cs425.eregistrar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ERegistrarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ERegistrarApplication.class, args);
	}

	@Configuration
	public class WebAppConfig implements WebMvcConfigurer {
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("forward:/eregistrar/home");
		}
	}

}
