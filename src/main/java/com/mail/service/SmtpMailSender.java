package com.mail.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Service
public class SmtpMailSender
{	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String send(String to,String subject,String body) throws MessagingException
	{
		MimeMessage message=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		
		try
		{
		helper.setText(subject);
		helper.setTo(to);
		helper.setSubject(body);
		}
		
		catch(Exception e)
		{
			return "Error in mail sending";
		}
		javaMailSender.send(message);
		return "mail sent!!";
		
	}

}
