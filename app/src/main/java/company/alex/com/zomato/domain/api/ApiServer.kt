package company.alex.com.zomato.domain.api

import company.alex.com.zomato.datasources.remote.dtos.responses.RestaurantCategoriesResponse
import company.alex.com.zomato.datasources.remote.dtos.responses.SearchCityResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServer {

    @GET("categories")
    fun getRestaurantCategories(): Observable<RestaurantCategoriesResponse>

    @GET("cities")
    fun getCityInfo(@Query("city_ids") cityId: Int): Observable<SearchCityResponse>
}