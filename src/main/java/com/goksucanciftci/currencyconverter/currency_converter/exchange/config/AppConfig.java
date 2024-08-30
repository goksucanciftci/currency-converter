package com.goksucanciftci.currencyconverter.currency_converter.exchange.config;

import com.goksucanciftci.currencyconverter.currency_converter.exchange.cache.ExchangeRateCache;
import com.goksucanciftci.currencyconverter.currency_converter.exchange.client.ExchangeRateClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	/**
	 * Configures and provides a singleton instance of ExchangeRateCache.
	 *
	 * @return A new instance of ExchangeRateCache
	 */
	@Bean
	public ExchangeRateCache exchangeRateCache() {
		return new ExchangeRateCache();
	}

	/**
	 * Configures and provides a singleton instance of ExchangeRateClientFactory.
	 *
	 * @return A new instance of ExchangeRateClientFactory
	 */
	@Bean
	public ExchangeRateClientFactory exchangeRateClientFactory() {
		return new ExchangeRateClientFactory();
	}
}