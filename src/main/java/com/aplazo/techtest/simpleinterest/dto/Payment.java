package com.aplazo.techtest.simpleinterest.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
	/**
	 * 
	 */
	private Integer payment_number;
	
	/**
	 * 
	 */
	private Double amount;
	
	/**
	 * 
	 */
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date payment_date;

}
