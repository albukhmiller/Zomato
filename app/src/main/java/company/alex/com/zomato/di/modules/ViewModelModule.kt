package company.alex.com.zomato.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import company.alex.com.zomato.di.scopes.ViewModelKey
import company.alex.com.zomato.di.viewModelProvider.ViewModelFactory
import company.alex.com.zomato.ui.presentation.laptop.SharedViewModel
import company.alex.com.zomato.ui.presentation.mainScreen.MainViewModel
import company.alex.com.zomato.ui.presentation.searchCity.SearchCityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun providesViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun providesMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchCityViewModel::class)
    internal abstract fun providesSearchCityViewModel(searchCityViewModel: SearchCityViewModel): ViewModel

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(SharedViewModel::class)
    internal abstract fun providesSharedViewModel(sharedViewModel: SharedViewModel): ViewModel
}