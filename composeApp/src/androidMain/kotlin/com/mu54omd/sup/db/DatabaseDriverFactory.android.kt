package com.mu54omd.sup.db

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory(private val context: Context) {
    actual suspend fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = SupDatabase.Schema.synchronous(),
            context = context,
            name = "Sup.Database.db"
        )
}