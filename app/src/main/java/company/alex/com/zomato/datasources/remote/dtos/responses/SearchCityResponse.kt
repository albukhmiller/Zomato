package company.alex.com.zomato.datasources.remote.dtos.responses

import com.google.gson.annotations.SerializedName
import company.alex.com.zomato.datasources.remote.dtos.city.CityInfoDto

data class SearchCityResponse(@SerializedName("location_suggestions") val cityInfoDto: MutableList<CityInfoDto>)