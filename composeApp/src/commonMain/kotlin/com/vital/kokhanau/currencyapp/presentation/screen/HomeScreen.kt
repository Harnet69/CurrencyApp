package com.vital.kokhanau.currencyapp.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import currencyapp.composeapp.generated.resources.Res
import currencyapp.composeapp.generated.resources.rates_fresh
import org.jetbrains.compose.resources.getString

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        LaunchedEffect(Unit) {
            println( getString(Res.string.rates_fresh))
        }
    }
}