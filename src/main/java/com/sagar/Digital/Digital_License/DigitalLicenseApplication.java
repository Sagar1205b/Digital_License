package com.sagar.Digital.Digital_License;

import com.sagar.Digital.Digital_License.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
public class DigitalLicenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalLicenseApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	Random random=new Random();
	int otp=100000+random.nextInt(900000);
	@Autowired
	private EmailSenderService emailSenderService;
//
//	String body = "Hi Sagar,\nYour one time password is " + otp + ".\nPlease don't share this with anyone.";
//	@EventListener(ApplicationReadyEvent.class)
//	public  void sendMail(){
//		emailSenderService.sendEmail("sbadammanavar@gmail.com","Testing mail service",body);
//	}



}
