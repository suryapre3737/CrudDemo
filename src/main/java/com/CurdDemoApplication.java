package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurdDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CurdDemoApplication.class, args);

		/*ConfigurableApplicationContext ctx = SpringApplication.run(CurdDemoApplication.class, args);
		WeatherService weatherService = (WeatherService) ctx.getBean("weatherService");
		System.out.println(weatherService.getTodaysWeatherInfo());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WeatherService weatherService1 = (WeatherService) ctx.getBean("weatherService");
		System.out.println(weatherService1.getTodaysWeatherInfo());*/
	}

}
