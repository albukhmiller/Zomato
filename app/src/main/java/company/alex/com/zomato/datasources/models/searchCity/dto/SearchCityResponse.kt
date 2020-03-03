package company.alex.com.zomato.datasources.models.searchCity.dto

import com.google.gson.annotations.SerializedName
import company.alex.com.zomato.datasources.models.searchCity.CityInfo

data class SearchCityResponse(@SerializedName("location_suggestions") val cityInfo: MutableList<CityInfo>)