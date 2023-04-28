package com.anmollearning.springBootSimpleREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmollearning.springBootSimpleREST.Model.CurrencyServiceConfigurationProperties;

@RestController
public class CurrencyServiceController {

	@Autowired
	CurrencyServiceConfigurationProperties configurationProperties;
	
	@RequestMapping("/currency-service")
	public CurrencyServiceConfigurationProperties getCurrencyService() {
		return configurationProperties;
	}
	
}
