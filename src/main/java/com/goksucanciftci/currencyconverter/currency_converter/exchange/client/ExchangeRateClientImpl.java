package com.goksucanciftci.currencyconverter.currency_converter.exchange.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExchangeRateClientImpl implements ExchangeRateClient {

	// The URL of the exchange rate API
	public static String API_URL;

	// Setter method to inject the API URL from application properties
	@Value ("${api.url}")
	public void setAPI_URL(String url) {
		API_URL = url;
	}
	@Override
	public Double getRate(String currency) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> response;
		Map<String, Number> rates =new HashMap<>();
		// Fetch the response from the API as a Map
		try{
			response = restTemplate.getForObject(API_URL, Map.class);

			// Extract the 'rates' key from the response as a Map
			rates = (Map<String, Number>) response.get("rates");
		}catch (ClassCastException e){
			System.out.println("ERROR" + e.getMessage());
		}

		// Convert the rates Map from Number to Double to handle any non-double values
		Map<String, Double> doubleRates = new HashMap<>();
		for (Map.Entry<String, Number> entry : rates.entrySet()) {
			doubleRates.put(entry.getKey(), entry.getValue().doubleValue());
		}
		// Return the exchange rate for the specified currency
		return doubleRates.get(currency);
	}

	@Override
	public Map<String, String> getAvailableCurrencies() {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
		Map<String, String> currencies = new HashMap<>();

		// Extract the 'rates' key from the response and list all available currencies
		Map<String, Double> rates = (Map<String, Double>) response.get("rates");
		for (String currency : rates.keySet()) {
			currencies.put(currency, currency);   // Use the currency code as both key and value
		}
		return currencies;
	}
}
