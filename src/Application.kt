package com.myapp

import com.myapp.common.DBInitializer
import com.myapp.common.EnvConstants
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    DBInitializer().execute()
    routing {
        get("/" ) {
            call.respond("Hello World")
        }
    }
}
