package com.acurvelo.salesapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.acurvelo.salesapp.entities.Sales;
import com.acurvelo.salesapp.repositories.SalesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
@Slf4j
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;
	
	@Value("${twilio.key}")
	private String twilioKey;
	
	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;
	
	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	private SalesRepository salesRepository;

	public SmsService(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}
	
	public void sendSms(Long saleId) {
		Sales sales = salesRepository.findById(saleId).get();

		if (sales == null)
			throw new RuntimeException("Sales not found");

		String date = sales.getDate().getMonth() + "/" + sales.getDate().getYear();
		
		String msg = "Seller " + sales.getSellerName() + " sold in " + date +
					 " an amount of $ " + String.format("%.2f", sales.getAmount());
		
		Twilio.init(twilioSid, twilioKey);
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Message message = Message.creator(to, from, msg).create();
		log.info("Message ID: " + message.getSid());
	}
}
