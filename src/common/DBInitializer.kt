package com.myapp.common

import com.myapp.model.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DBInitializer {

    fun init() {
        val url = "jdbc:postgresql://${EnvConstants.DATABASE_HOST}:${EnvConstants.DATABASE_PORT}/${EnvConstants.DATABASE_NAME}"
        Database.connect(url, DRIVER, EnvConstants.DATABASE_USER, EnvConstants.DATABASE_PASSWORD)
        println(url)

        transaction {
            SchemaUtils.create(
                Users
            )
        }
    }

    companion object {
        const val DRIVER = "org.postgresql.Driver"
    }
}
