package company.alex.com.zomato.di.components

import company.alex.com.zomato.di.modules.AppModule
import company.alex.com.zomato.di.modules.NetworkModule
import company.alex.com.zomato.di.modules.ViewModelModule
import company.alex.com.zomato.ui.presentation.laptop.Laptop1Fragment
import company.alex.com.zomato.ui.presentation.laptop.Laptop2Fragment
import company.alex.com.zomato.ui.presentation.mainScreen.MainFragment
import company.alex.com.zomato.ui.presentation.searchCity.SearchCityFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NetworkModule::class])
interface AppComponents {

    fun inject(mainFragment: MainFragment)
    fun inject(searchCityFragment: SearchCityFragment)

    fun inject(laptop1Fragment: Laptop1Fragment)
    fun inject(laptop2Fragment: Laptop2Fragment)
}