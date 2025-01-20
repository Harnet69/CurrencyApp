package com.vital.kokhanau.currencyapp.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import com.vital.kokhanau.currencyapp.data.remote.api.CurrencyApiServiceImpl

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        LaunchedEffect(Unit) {
            CurrencyApiServiceImpl().getLatestCurrenciesRates()
        }
    }
}