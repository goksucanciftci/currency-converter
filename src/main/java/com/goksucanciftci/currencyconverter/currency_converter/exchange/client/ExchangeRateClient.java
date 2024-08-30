package com.goksucanciftci.currencyconverter.currency_converter.exchange.client;

import java.util.Map;
public interface ExchangeRateClient {

	/**
	 * Retrieves the exchange rate for the specified currency.
	 *
	 * @param currency The currency code (e.g., "USD")
	 * @return The exchange rate for the given currency
	 */
	Double getRate(String currency);

	/**
	 * Retrieves a map of available currencies and their corresponding names.
	 *
	 * @return A map where the key is the currency code and the value is the currency name
	 */
	Map<String, String> getAvailableCurrencies();
}