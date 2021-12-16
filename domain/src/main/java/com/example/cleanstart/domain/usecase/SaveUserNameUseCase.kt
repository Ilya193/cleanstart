package com.example.cleanstart.domain.usecase

import com.example.cleanstart.domain.models.SaveUserNameParam
import com.example.cleanstart.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(param)
    }
}