package com.aplazo.techtest.simpleinterest.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.aplazo.techtest.simpleinterest.dto.RequestDTO;
import com.aplazo.techtest.simpleinterest.dto.Payment;
import com.aplazo.techtest.simpleinterest.exceptions.RequestException;
import com.aplazo.techtest.simpleinterest.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	/**
	 * @throws RequestException 
	 *
	 */
	@Override
	public List<Payment> getPaymentTable(RequestDTO request) throws RequestException {
		
		if(!requestValido(request)) {
			throw new RequestException();
		}
		
		List<Payment> tabla = crearTablaPagos(request.getAmount(), request.getRate(), request.getTerms());
		
		return tabla;
	}

	
	private List<Payment> crearTablaPagos(Double amount, Double rate, Integer terms) {
		List<Payment> tabla = new ArrayList<>();
		
		/*calculamos para cada N terms*/
		LocalDate hoy = LocalDate.now();
		Double pagosemanal = amount/terms;
		Double tot = (amount*(rate/100))/terms;
		for(int i=0 ; i<terms ; i++) {
			int payNum = i+1;
			Payment pay = new Payment();
			pay.setPayment_number(payNum);
			pay.setAmount(pagosemanal+tot);
			pay.setPayment_date(obtenerSemanaN(hoy, payNum));
			tabla.add(pay);
		}
		
		return tabla;
	}


	private Date obtenerSemanaN(LocalDate hoy, int i) {
		
		LocalDate fechaNsemanas = hoy.plusWeeks(i);
		return Date.from(fechaNsemanas.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}


	/**
	 * @param request 
	 * @return
	 */
	private boolean requestValido(RequestDTO request) {
		
		boolean valido = true;
		if(request.getAmount() == null || request.getAmount()<=0) {
			valido = false;
		}else if(valido && (request.getRate()==null || request.getRate()<=0)) {
			valido = false;
		}else if(valido &&( request.getTerms()==null || request.getTerms()<=0)) {
			valido = false;
		}
		return valido;
	}

}
