package company.alex.com.zomato.ui.presentation.laptop

import android.util.Log
import androidx.lifecycle.MutableLiveData
import company.alex.com.zomato.datasources.remote.dtos.city.CityInfoDto
import company.alex.com.zomato.domain.inretactors.CityInteractor
import company.alex.com.zomato.ui.presentation.common.BaseViewModel
import javax.inject.Inject

class SharedViewModel @Inject constructor(private val cityInteractor: CityInteractor) : BaseViewModel() {

    var cityInfo = MutableLiveData<CityInfoDto>()

    fun loadCityInfo() {
        cityInteractor.search(123)
            .subscribe({
                cityInfo.value = it.cityInfoDto[0]
            }, { error -> Log.d("TAG", error.message) })
    }
}