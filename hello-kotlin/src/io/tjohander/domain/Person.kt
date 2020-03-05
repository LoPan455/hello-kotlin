package io.tjohander.domain

open class Person {
    var firstName: String = ""
    var lastName: String  = ""
    open fun getName(): String = "$firstName $lastName"
}
