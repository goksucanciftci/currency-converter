package com.goksucanciftci.currencyconverter.currency_converter.exchange.service;

import com.goksucanciftci.currencyconverter.currency_converter.exchange.cache.ExchangeRateCache;
import com.goksucanciftci.currencyconverter.currency_converter.exchange.model.ConversionRequest;
import com.goksucanciftci.currencyconverter.currency_converter.exchange.model.ConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyConversionService {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@Autowired
	private ExchangeRateCache cache;



	/**
	 * Converts an amount from one currency to another based on the exchange rates.
	 *
	 * @param request The conversion request containing the amount, source currency, and target currency
	 * @return The conversion response containing the converted amount
	 */
	public ConversionResponse convert(ConversionRequest request) {
		// Retrieve exchange rates from the cache
		Double fromRate = cache.getRate(request.getFromCurrency());
		Double toRate = cache.getRate(request.getToCurrency());

		// If the exchange rates are not available in the cache, fetch them from the API
		if (fromRate == null) {
			fromRate = exchangeRateService.getExchangeRate(request.getFromCurrency());
			cache.putRate(request.getFromCurrency(), fromRate);
		}

		if (toRate == null) {
			toRate = exchangeRateService.getExchangeRate(request.getToCurrency());
			cache.putRate(request.getToCurrency(), toRate);
		}

		// Perform the currency conversion
		Double convertedAmount = (request.getAmount() / fromRate) * toRate;

		return new ConversionResponse(convertedAmount);
	}

	/**
	 * Retrieves a list of available currencies supported by the service.
	 *
	 * @return A map of available currencies, where the key is the currency code and the value is the currency name
	 */
	public Map<String, String> getAvailableCurrencies() {
		return exchangeRateService.getAvailableCurrencies();
	}
}
