package com.myapp

import com.myapp.common.DBInitializer
import com.myapp.common.EnvConstants
import com.myapp.model.User
import com.myapp.model.UserData
import com.myapp.model.Users
import com.myapp.model.toData
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.get
import io.ktor.routing.routing
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    DBInitializer().execute()
    routing {
        get("/" ) {
            lateinit var user :UserData
            transaction {
                user = User.new {
                    name = "Tom"
                    age = 20
                    createdAt = DateTime.now()
                    updatedAt = DateTime.now()
                }.toData()
            }
            call.respond("Hello World : " + user.name)
        }
    }
}
