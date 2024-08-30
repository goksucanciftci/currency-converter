package com.goksucanciftci.currencyconverter.currency_converter.exchange.service;

import com.goksucanciftci.currencyconverter.currency_converter.exchange.client.ExchangeRateClient;
import com.goksucanciftci.currencyconverter.currency_converter.exchange.client.ExchangeRateClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExchangeRateService {


	private ExchangeRateClientFactory clientFactory;

	private ExchangeRateClient exchangeRateClient;

	/**
	 * Constructor that initializes the ExchangeRateClient using the provided factory.
	 *
	 * @param clientFactory Factory to create ExchangeRateClient instances
	 */
	@Autowired
	public ExchangeRateService(ExchangeRateClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		this.exchangeRateClient = clientFactory.createClient(); // ExchangeRateClient nesnesini constructor içinde oluşturuyoruz
	}


	/**
	 * Retrieves the exchange rate for the specified currency.
	 *
	 * @param currency The currency code for which the exchange rate is requested
	 * @return The exchange rate for the given currency
	 */
	public Double getExchangeRate(String currency) {
		return exchangeRateClient.getRate(currency);
	}


	/**
	 * Retrieves a map of available currencies.
	 *
	 * @return A map where the key is the currency code and the value is the currency name
	 */
	public Map<String, String> getAvailableCurrencies() {
		return exchangeRateClient.getAvailableCurrencies();
	}
}