package company.alex.com.zomato.ui.presentation.searchCity

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import company.alex.com.zomato.datasources.remote.dtos.city.CityInfoDto
import company.alex.com.zomato.domain.inretactors.CityInteractor
import company.alex.com.zomato.ui.presentation.common.BaseViewModel
import javax.inject.Inject

class SearchCityViewModel @Inject constructor(private val cityInteractor: CityInteractor) : BaseViewModel() {

    var cityInfo = ObservableField<CityInfoDto>()
    var restaurantCaregory = ""


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        cityInteractor.search(123)
            .subscribe({ cityInfo.set(it.cityInfoDto[0]) },
                { error -> Log.d("TAG", error.message) })
    }

}