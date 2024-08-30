package com.goksucanciftci.currencyconverter.currency_converter.exchange.client;

public class ExchangeRateClientFactory {

	/**
	 * Creates and returns an instance of ExchangeRateClient.
	 *
	 * @return A new instance of ExchangeRateClient
	 */
	public ExchangeRateClient createClient() {
		return new ExchangeRateClientImpl();
	}
}
