package company.alex.com.zomato.datasources.remote.city

import company.alex.com.zomato.domain.api.ApiServer
import javax.inject.Inject

class CityRemoteDataSource @Inject constructor(private val apiServer: ApiServer) {

    fun getInfo(cityId: Int) = apiServer.getCityInfo(cityId)
}