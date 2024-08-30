# Currency Converter Application
## Overview
This is a simple currency converter web application built with Spring Boot. The application allows users to convert an amount from one currency to another using the latest exchange rates fetched from a public API. The project includes both the backend service that handles the exchange rate data and a simple web interface for user interaction.

The architecture of the project is modular and maintainable; every class has a purpose in currency conversion. CurrencyConversionService lies at the heart of business logic, performing conversion calculations by given exchange rates received via an external API with the help of ExchangeRateClientImpl. This client is created using the ExchangeRateClientFactory, abstracting the instantiation of the API Client. It would then give the flexibility to switch between the different API implementation if needed in the future.

Classes ConversionRequest and ConversionResponse allow one to encapsulate the input and respective output in the currency conversion process. The ConversionRequest class includes details regarding an amount, source currency, and a target currency. In contrast, ConversionResponse will hold the converted amount plus the details of the currencies. These classes ensure that data flowing within the application is clean and well-structured.

AppConfig is responsible for configuring all beans, including RestTemplate and caching mechanisms, and handling the setup. Proper initialization of components in this configuration class makes them free for modification or extension in any manner.

Furthermore, CurrencyConversionController acts as the interface from the frontend to the backend, exposing endpoints responsible for handling requests to convert currency and retrieve exchange rates. This way, API keys or other sensitive information will not be exposed, but additional control over data will be maintained by proxying API calls through the backend.

The overall design ensures separation of concerns and greatly enhances flexibility, security, and performance of an application. Creation patterns and configuration classes, structured data models all this ensures that the application is strong and can easily survive future changes.
## Configure the API key:
Sign up for an API key at exchangeratesapi.io

Add your API key to **application.properties** under the **api.url** property.

## Features

●  Currency Conversion: Input fields for the amount, and dropdowns for selecting the "from" and "to" currencies.

●  Exchange Rates: Fetches the latest exchange rates from a public API (exchangeratesapi.io) and performs the conversion on the backend.

●  API Proxying: Exchange rate API calls are proxied through the backend, enhancing security and control.

●  Caching: Implements caching for exchange rate data to reduce redundant API calls and improve performance.

## Project Structure
### Controller
●  **CurrencyConversionController**: Handles API requests for currency conversion.

### Services
●  **CurrencyConversionService**: Contains the business logic for converting currencies.

●  **ExchangeRateService**: Manages interactions with the exchange rate API, including data retrieval and caching.

### Client and Cache
●  **ExchangeRateClient**: Interfaces with the external exchange rate API.

●  **ExchangeRateCache**: Caches exchange rates to minimize API calls.


## Getting Started
### Prerequisites

●  **Java**: Ensure that you have Java 17.

●  **Gradle**: The project uses Gradle as its build tool.

