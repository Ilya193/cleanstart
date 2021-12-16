package com.example.cleanstart.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.data.data.repository.UserRepositoryImpl
import com.example.cleanstart.databinding.ActivityMainBinding
import com.example.cleanstart.domain.models.SaveUserNameParam
import com.example.cleanstart.domain.usecase.GetUserNameUseCase
import com.example.cleanstart.domain.usecase.SaveUserNameUserCase
import com.example.data.data.storage.SharedPrefUserStorage
import com.example.data.data.storage.UserStorage

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var vm: MainViewModel

    private val userRepository by lazy { UserRepositoryImpl(SharedPrefUserStorage(applicationContext)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUserCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.receiveButton.setOnClickListener {
            val username = getUserNameUseCase.execute()
            binding.getDataText.text = username.firstName + " " + username.lastName
        }

        binding.sendButton.setOnClickListener {
            val text = binding.putDataText.text.toString()
            val params = SaveUserNameParam(text)
            val result = saveUserNameUseCase.execute(params)

            Toast.makeText(this, "$result", Toast.LENGTH_SHORT).show()
        }
    }
}