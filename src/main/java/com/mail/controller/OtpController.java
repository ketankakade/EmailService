package com.mail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.service.MyEmailService;
import com.mail.service.OtpService;


@RestController
@RequestMapping("/Mail")
public class OtpController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public OtpService otpService;
	
	@Autowired
	public MyEmailService myEmailService;

	@GetMapping("/generateOtp")
	public void generateOtp(){
				
		String otp = otpService.generateOTP();
		 
		logger.info("OTP : "+otp);
		
		myEmailService.sendOtpMessage("ketankakadetest@gmail.com", "OTP -SpringBoot", otp);		
		
	}
	
	
}
