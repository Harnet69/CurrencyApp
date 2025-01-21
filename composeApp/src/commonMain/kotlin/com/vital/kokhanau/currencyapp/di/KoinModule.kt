package com.vital.kokhanau.currencyapp.di

import com.russhwolf.settings.Settings
import com.vital.kokhanau.currencyapp.data.local.PreferencesRepositoryImpl
import com.vital.kokhanau.currencyapp.data.remote.api.CurrencyApiServiceImpl
import com.vital.kokhanau.currencyapp.domain.CurrencyApiService
import com.vital.kokhanau.currencyapp.domain.PreferencesRepository
import org.koin.core.context.startKoin

import org.koin.dsl.module

val appModule = module {
    single { Settings() }

    single<PreferencesRepository>{PreferencesRepositoryImpl(settings = get())}

    single<CurrencyApiService>{CurrencyApiServiceImpl(preferencesRepository = get())}
}

fun initializeKoin(){
    startKoin {
        modules(appModule)
    }
}