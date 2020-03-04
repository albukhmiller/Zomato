package company.alex.com.zomato.datasources.remote.restaurants

import company.alex.com.zomato.domain.api.ApiServer
import javax.inject.Inject

class RestaurantRemoteDataSource @Inject constructor(private val apiServer: ApiServer) {

    fun getCategories() = apiServer.getRestaurantCategories()
}