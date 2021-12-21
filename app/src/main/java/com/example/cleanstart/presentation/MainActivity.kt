package com.example.cleanstart.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanstart.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.receiveButton.setOnClickListener {
            //binding.getDataText.text =
            vm.load()
        }

        binding.sendButton.setOnClickListener {
            val text = binding.putDataText.text.toString()
            vm.save(text)
        }

        vm.data.observe(this) { data ->
            binding.getDataText.text = data
        }
    }
}