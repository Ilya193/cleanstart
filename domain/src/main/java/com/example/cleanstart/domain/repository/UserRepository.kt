package com.example.cleanstart.domain.repository

import com.example.cleanstart.domain.models.SaveUserNameParam
import com.example.cleanstart.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}