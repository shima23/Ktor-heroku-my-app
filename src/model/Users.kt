package com.myapp.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.CurrentDateTime

object Users : IntIdTable("users") {
    val name = varchar("name", 100)
    val age = integer("age")
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime())
    val updatedAt = datetime("updated_at").defaultExpression(CurrentDateTime())
}

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
    var age by Users.age
    var createdAt by Users.createdAt
    var updatedAt by Users.updatedAt
}

fun User.toData(): UserData {
    return UserData(
        id = id.value,
        name = name,
        age = age,
        createdAt = createdAt.toString("yyyy/MM/dd HH:mm:ss.SSS"),
        updatedAt = updatedAt.toString("yyyy/MM/dd HH:mm:ss.SSS")
    )
}

data class UserData(
    var id: Int,
    var name: String,
    var age: Int,
    var createdAt: String,
    var updatedAt: String
)
