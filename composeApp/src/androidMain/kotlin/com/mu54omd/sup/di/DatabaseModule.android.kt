package com.mu54omd.sup.di

import app.cash.sqldelight.db.SqlDriver
import com.mu54omd.sup.db.DatabaseDriverFactory
import mu54omd.sup.db.SupDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val databaseModule: Module = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<SupDatabase> { SupDatabase(get()) }
}
