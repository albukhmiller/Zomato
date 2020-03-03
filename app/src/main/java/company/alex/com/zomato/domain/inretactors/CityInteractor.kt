package company.alex.com.zomato.domain.inretactors

import company.alex.com.zomato.domain.api.ApiServer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CityInteractor @Inject constructor(private val serverApi: ApiServer) {

    fun search(cityId: Int) = serverApi.getCityInfo(cityId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
}