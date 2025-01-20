package com.vital.kokhanau.currencyapp.data.remote.api

import com.vital.kokhanau.currencyapp.domain.CurrencyApiService
import com.vital.kokhanau.currencyapp.domain.model.ApiResponse
import com.vital.kokhanau.currencyapp.domain.model.Currency
import com.vital.kokhanau.currencyapp.domain.model.RequestState
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class CurrencyApiServiceImpl : CurrencyApiService {
    // Negotiating media types between the client and server
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            // Ktor out-of-the-box formats: JSON, XML, and CBOR
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000
        }
        install(DefaultRequest) {
            headers {
                append("apikey", API_KEY)
            }
        }
    }

    override suspend fun getLatestCurrenciesRates(): RequestState<List<Currency>> {
        return try {
            val response = httpClient.get(ENDPOINT)
            if (response.status.value == HttpStatusCode.OK.value) {
                val apiResponse = Json.decodeFromString<ApiResponse>(response.body())
//                val availableCurrencyCodes = apiResponse.data.keys
//                    .filter {
//                        CurrencyCode.entries
//                            .map { code -> code.name }
//                            .toSet()
//                            .contains(it)
//                    }
//
                val availableCurrencies = apiResponse.data.values.toList()
//                    .filter { currency ->
//                        availableCurrencyCodes.contains(currency.code)
//                    }
//                    .map { it.toCurrency() }
//
//                // Persist a timestamp
//                val lastUpdated = apiResponse.meta.lastUpdatedAt
//                preferences.saveLastUpdated(lastUpdated)
                println("getLatestCurrenciesRates: ${response.body<String>()}")
                RequestState.Success(data = availableCurrencies)
            } else {
                RequestState.Error(message = "HTTP Error Code: ${response.status}")
            }
        } catch (e: Exception) {
            RequestState.Error(message = e.message.toString())
        }
    }

    companion object {
        const val ENDPOINT = "https://api.currencyapi.com/v3/latest"
        const val API_KEY = "cur_live_sy6bKUxxaI5c20Zd0eIRUtzDJTAPNQvO48wzWtP7"
    }
}