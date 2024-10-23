package com.acurvelo.salesapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acurvelo.salesapp.entities.Sales;
import com.acurvelo.salesapp.repositories.SalesRepository;

@Service
public class SalesService {

	private SalesRepository salesRepository;

	public SalesService(SalesRepository salesRepository){
		this.salesRepository =salesRepository;
	}
	
	public Page<Sales> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusDays(120) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		return salesRepository.findSales(min, max, pageable);
	}
}
