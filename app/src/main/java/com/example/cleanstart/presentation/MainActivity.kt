package com.example.cleanstart.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cleanstart.app.App
import com.example.cleanstart.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

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