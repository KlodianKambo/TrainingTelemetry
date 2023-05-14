package com.klodian.kambo

import com.klodian.kambo.domain.repositories.UserRepository
import com.klodian.kambo.enterprise.entities.PublicUser
import com.klodian.kambo.enterprise.entities.UserGender
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(): UserRepository {
    override suspend fun getCurrentUser() = PublicUser(
        id = "1",
        name = "Klodian",
        age = 33,
        gender = UserGender.M
    )
}