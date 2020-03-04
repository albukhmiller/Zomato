package company.alex.com.zomato.domain.inretactors

import company.alex.com.zomato.datasources.remote.city.CityRemoteDataSource
import company.alex.com.zomato.models.searchCity.CityInfo
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CityInteractor @Inject constructor(private val dataSource: CityRemoteDataSource) {

    fun search(cityId: Int) = dataSource.getInfo(cityId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .toFlowable(BackpressureStrategy.LATEST)
        .map { result ->
            return@map CityInfo(
                result.cityInfoDto[0].cityId,
                result.cityInfoDto[0].name,
                result.cityInfoDto[0].countryName,
                result.cityInfoDto[0].flag
            )
        }
}