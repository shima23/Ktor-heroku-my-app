package com.myapp.common

import io.github.cdimascio.dotenv.Dotenv

object EnvConstants {
    private val dotenv = Dotenv.configure().ignoreIfMissing().load()
    private var env: String? = null

    val ENV: String get() = env ?: dotenv["ENV"]!!
    val DATABASE_HOST: String get() = dotenv["DATABASE_HOST"]!!
    val DATABASE_PORT: String get() = dotenv["DATABASE_PORT"]!!
    val DATABASE_NAME: String get() = dotenv["DATABASE_NAME"]!!
    val DATABASE_USER: String get() = dotenv["DATABASE_USER"]!!
    val DATABASE_PASSWORD: String get() = dotenv["DATABASE_PASSWORD"]!!
}
