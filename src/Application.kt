package com.myapp

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    //dbInitialize()
    routing {
        get("/" ) {
            call.respond("Hello World")
        }
    }
}

//fun dbInitialize() {
//    val url = "jdbc:postgresql://${EnvConstants.DATABASE_HOST}:${EnvConstants.DATABASE_PORT}/${EnvConstants.DATABASE_NAME}"
//    println(url)
//    Database.connect(url, driver = "org.postgresql.Driver", user = EnvConstants.DATABASE_USER, password = EnvConstants.DATABASE_PASSWORD)
//}
