package company.alex.com.zomato.ui.presentation.mainScreen

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import company.alex.com.zomato.R
import company.alex.com.zomato.datasources.models.restaurant.Category
import company.alex.com.zomato.domain.inretactors.RestaurantInteractor
import company.alex.com.zomato.ui.presentation.common.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val restaurantInteractor: RestaurantInteractor) : BaseViewModel() {

    var restaurantCategory = ObservableField<List<Category>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        restaurantInteractor.getCategories()
            .subscribe({
                restaurantCategory.set(it.categories)
            }, { error -> Log.d("TAG", error.message) })
    }

    fun openSearchCityScreen() {
        navigateTo(R.id.searchCityFragment, restaurantCategory.get()!![0])
    }


    fun  openLaptopActivity() {
        navigateTo(R.id.laptopActivity)
    }

}