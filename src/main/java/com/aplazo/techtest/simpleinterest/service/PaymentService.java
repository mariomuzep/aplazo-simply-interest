package com.aplazo.techtest.simpleinterest.service;

import com.aplazo.techtest.simpleinterest.dto.RequestDTO;

import java.util.List;

import com.aplazo.techtest.simpleinterest.dto.Payment;
import com.aplazo.techtest.simpleinterest.exceptions.RequestException;

public interface PaymentService {

	/**
	 * @param request
	 * @return
	 * @throws RequestException 
	 */
	List<Payment> getPaymentTable(RequestDTO request) throws RequestException;

	
}
