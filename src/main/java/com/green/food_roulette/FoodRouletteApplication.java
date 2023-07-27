package com.green.food_roulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableScheduling
@SpringBootApplication
public class FoodRouletteApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodRouletteApplication.class, args);
    }

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedHeaders("*") // 어떤 헤더들을 허용할 것인지
						.allowedMethods("*") // 어떤 메서드를 허용할 것인지 (GET, POST...)
						.allowedOrigins("https://web-food-roulette-rt92alkjme1ys.sel4.cloudtype.app");
			}
		};
	}

}
