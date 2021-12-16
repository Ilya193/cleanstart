package com.example.data.data.repository

import com.example.data.data.storage.User
import com.example.data.data.storage.UserStorage
import com.example.cleanstart.domain.models.SaveUserNameParam
import com.example.cleanstart.domain.models.UserName
import com.example.cleanstart.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {
    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveParam.name, lastName = "")
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}