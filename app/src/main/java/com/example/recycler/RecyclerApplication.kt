package com.example.recycler

import android.app.Application
import com.example.recycler.domain.di.domainModule
import com.example.recycler.presentation.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RecyclerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RecyclerApplication)
            modules(
                listOf(
                    domainModule,
                    viewModelModule
                )
            )
        }
    }
}