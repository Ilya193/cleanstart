package com.example.cleanstart.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanstart.domain.models.SaveUserNameParam
import com.example.cleanstart.domain.usecase.GetUserNameUseCase
import com.example.cleanstart.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {
    /*private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(applicationContext)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUserCase(userRepository) }*/

    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
        get() = _data

    fun save(text: String) {
        val params = SaveUserNameParam(text)
        val result = saveUserNameUseCase.execute(params)
        _data.value = "Save result: $text"
    }

    fun load() {
        val username = getUserNameUseCase.execute()
        _data.value = username.firstName + " " + username.lastName
    }
}