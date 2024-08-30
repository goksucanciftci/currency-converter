package com.goksucanciftci.currencyconverter.currency_converter.exchange.cache;

import java.util.HashMap;
import java.util.Map;
public class ExchangeRateCache {

	// A cache to store exchange rates (currency code -> exchange rate)
	private Map<String, Double> rateCache = new HashMap<>();


	/**
	 * Retrieves the exchange rate for the given currency from the cache.
	 *
	 * @param currency The currency code (e.g., "USD")
	 * @return The exchange rate (e.g., 1.18) if present in the cache; otherwise, null
	 */
	public Double getRate(String currency) {
		return rateCache.get(currency);
	}

	/**
	 * Adds the given currency and its exchange rate to the cache.
	 *
	 * @param currency The currency code
	 * @param rate The exchange rate
	 */
	public void putRate(String currency, Double rate) {
		rateCache.put(currency, rate);
	}
}