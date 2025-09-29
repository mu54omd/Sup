package com.mu54omd.sup.db


class SharedDatabase(private val databaseDriverFactory: DatabaseDriverFactory) {
    private var database: SupDatabase? = null
    private suspend fun initDatabase() {
        database.takeIf { it != null } ?: run {
            database = SupDatabase(databaseDriverFactory.createDriver())
        }
    }

    suspend operator fun <R> invoke(block: suspend (SupDatabase) -> R): R {
        initDatabase()
        return database.takeIf { it != null }?.let {
            block(it)
        } ?: throw IllegalStateException("Database is not initialized")
    }
}