package com.example.cleanstart.domain.usecase

import com.example.cleanstart.domain.models.UserName
import com.example.cleanstart.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(): UserName {
        return userRepository.getName()
    }
}