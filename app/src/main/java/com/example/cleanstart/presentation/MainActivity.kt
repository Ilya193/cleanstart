package com.example.cleanstart.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cleanstart.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val vm: MainViewModel by viewModel<MainViewModel>()

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