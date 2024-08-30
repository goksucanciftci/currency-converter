package com.goksucanciftci.currencyconverter.currency_converter.exchange.model;

public class ConversionRequest {

	private double amount;
	private String fromCurrency;
	private String toCurrency;

	// Getters and setters
	public double getAmount() {
		return amount;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

}