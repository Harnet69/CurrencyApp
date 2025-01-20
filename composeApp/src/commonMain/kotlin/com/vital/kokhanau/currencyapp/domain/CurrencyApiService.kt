package com.vital.kokhanau.currencyapp.domain

import com.vital.kokhanau.currencyapp.domain.model.Currency
import com.vital.kokhanau.currencyapp.domain.model.RequestState

interface CurrencyApiService {
    suspend fun getLatestCurrenciesRates(): RequestState<List<Currency>>
}
