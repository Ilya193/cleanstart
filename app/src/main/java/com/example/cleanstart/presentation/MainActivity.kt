package com.example.cleanstart.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cleanstart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

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