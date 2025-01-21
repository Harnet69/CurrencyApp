package com.vital.kokhanau.currencyapp.domain

import io.realm.kotlin.internal.interop.Timestamp

interface PreferencesRepository {
    suspend fun saveLastUpdated(lastUpdated: String)

    suspend fun isUpToDate(currentTimestamp: Long): Boolean
}