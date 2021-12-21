package com.example.cleanstart.app

import android.app.Application
import com.example.cleanstart.di.AppComponent
import com.example.cleanstart.di.AppModule
import com.example.cleanstart.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}