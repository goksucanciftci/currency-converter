package com.goksucanciftci.currencyconverter.currency_converter.exchange.controller;

import com.goksucanciftci.currencyconverter.currency_converter.exchange.model.ConversionRequest;
import com.goksucanciftci.currencyconverter.currency_converter.exchange.model.ConversionResponse;
import com.goksucanciftci.currencyconverter.currency_converter.exchange.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService conversionService;

	/**
	 * Handles the conversion of currency based on the provided request.
	 *
	 * @param request The conversion request containing source and target currencies and the amount to convert
	 * @return The response containing the converted amount and details
	 */
	@PostMapping("/convert")
	public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
		return conversionService.convert(request);
	}


	/**
	 * Retrieves a list of available currencies.
	 *
	 * @return A map of available currencies, where the key is the currency code and the value is the currency name
	 */
	@GetMapping("/currencies")
	public Map<String, String> getCurrencies() {
		return conversionService.getAvailableCurrencies();
	}
}
