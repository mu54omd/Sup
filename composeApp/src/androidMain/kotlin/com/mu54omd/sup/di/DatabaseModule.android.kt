package com.mu54omd.sup.di

import com.mu54omd.sup.db.DatabaseDriverFactory
import com.mu54omd.sup.db.SharedDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module = module {
    single { DatabaseDriverFactory(androidContext()) }
    single { SharedDatabase(get()) }
}
