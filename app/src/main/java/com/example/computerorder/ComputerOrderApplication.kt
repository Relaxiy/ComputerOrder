package com.example.computerorder

import android.app.Application
import com.example.computerorder.domain.di.domainModule
import com.example.computerorder.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class ComputerOrderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                listOf(
                    domainModule,
                    viewModelModule
                )
            )
        }
    }

}