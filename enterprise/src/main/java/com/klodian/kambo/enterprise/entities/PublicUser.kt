package com.klodian.kambo.enterprise.entities

data class PublicUser(
    val id: String,
    val name: String,
    val age: Int,
    val gender: UserGender
)