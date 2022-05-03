package com.aplazo.techtest.simpleinterest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplazo.techtest.simpleinterest.dto.RequestDTO;
import com.aplazo.techtest.simpleinterest.dto.Payment;
import com.aplazo.techtest.simpleinterest.exceptions.RequestException;
import com.aplazo.techtest.simpleinterest.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/simplyinterest")
public class SimpleInterestController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping(path = "/test")
	public String testService() {
		return "test ok!";
	}
	
	@PostMapping(path = "/table")
	public ResponseEntity<List<Payment>> getPaymentTable(@RequestBody final RequestDTO request) {
		log.info("Servicio getPaymentTable invocado");
		
		List<Payment> response;
		try {
			response = paymentService.getPaymentTable(request);
		} catch (RequestException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
