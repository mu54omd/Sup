package com.mu54omd.sup.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import mu54omd.sup.db.SupDatabase
import java.util.Properties

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        JdbcSqliteDriver(
            schema = SupDatabase.Schema,
            url = "jdbc:sqlite:Sup.Database.db",
            properties = Properties()
        )
}