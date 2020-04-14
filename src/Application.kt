package com.myapp

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.routing
import knub.common.EnvConstant
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    dbInitialize()
    routing {
        get("/" ) {
            call.respond("Hello World")
        }
    }
}

fun dbInitialize() {
    val url = "jdbc:postgresql://${EnvConstant.DATABASE_HOST}:${EnvConstant.DATABASE_PORT}/${EnvConstant.DATABASE_NAME}"
    println(url)
    Database.connect(url, driver = "org.postgresql.Driver", user = EnvConstant.DATABASE_USER, password = EnvConstant.DATABASE_PASSWORD)
}
