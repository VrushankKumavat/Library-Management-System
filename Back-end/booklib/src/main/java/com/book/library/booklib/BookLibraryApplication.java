package com.book.library.booklib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookLibraryApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer crosConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("http://localhost:4200/").allowCredentials(true);
//			}
//		};
//	}
	
}
