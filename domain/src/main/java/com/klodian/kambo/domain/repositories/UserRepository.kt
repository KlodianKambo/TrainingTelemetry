package com.klodian.kambo.domain.repositories

import com.klodian.kambo.enterprise.entities.PublicUser


interface UserRepository {
   suspend fun getCurrentUser() : PublicUser
}