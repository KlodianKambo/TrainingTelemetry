package com.klodian.kambo.domain.usecases

import com.klodian.kambo.domain.repositories.UserRepository
import com.klodian.kambo.enterprise.entities.PublicUser
import javax.inject.Inject

interface GetCurrentUserUseCase : suspend () -> PublicUser

class GetCurrentUserUseCaseImpl
@Inject constructor(private val userRepository: UserRepository) : GetCurrentUserUseCase {
   override suspend fun invoke(): PublicUser = userRepository.getCurrentUser()
}