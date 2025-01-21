package com.vital.kokhanau.currencyapp.domain.model

import androidx.compose.ui.graphics.Color

enum class RateStatus(
val title: String,
val color: Color
) {
    Idle(
        title = "",
        color = Color.White
    )
}