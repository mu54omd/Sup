package com.mu54omd.sup

import android.app.Application
import com.mu54omd.sup.di.initKoin
import org.koin.android.ext.koin.androidContext

class SupApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@SupApplication)
        }
    }
}