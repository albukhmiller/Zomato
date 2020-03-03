package company.alex.com.zomato.domain.api

import company.alex.com.zomato.datasources.models.restaurant.Data
import company.alex.com.zomato.datasources.models.searchCity.dto.SearchCityResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServer {

    @GET("categories")
    fun getRestaurantCategories(): Flowable<Data>

    @GET("cities")
    fun getCityInfo(@Query("city_ids") cityId: Int): Flowable<SearchCityResponse>
}