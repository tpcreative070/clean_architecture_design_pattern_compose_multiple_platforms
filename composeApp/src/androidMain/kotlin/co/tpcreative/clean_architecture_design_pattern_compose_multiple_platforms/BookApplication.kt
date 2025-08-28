package co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms

import android.app.Application
import co.tpcreative.clean_architecture_design_pattern_compose_multiple_platforms.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}