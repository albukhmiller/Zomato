package company.alex.com.zomato.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {

    @Provides
    @Singleton
    fun providesContext(): Context = app

    @Provides
    @Singleton
    fun providesSharedPreference() = app.getSharedPreferences("test", Context.MODE_PRIVATE)
}