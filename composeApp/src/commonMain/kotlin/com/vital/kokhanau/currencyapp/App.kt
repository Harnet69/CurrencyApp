package com.vital.kokhanau.currencyapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.vital.kokhanau.currencyapp.di.initializeKoin
import com.vital.kokhanau.currencyapp.presentation.screen.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    initializeKoin()

    MaterialTheme {
        Navigator(HomeScreen())
    }
}
