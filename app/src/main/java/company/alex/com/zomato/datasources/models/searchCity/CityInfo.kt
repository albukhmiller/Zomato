package company.alex.com.zomato.datasources.models.searchCity

import com.google.gson.annotations.SerializedName

data class CityInfo(
    @SerializedName("country_id") val cityId : Int,
    val name: String,
    @SerializedName("country_name") val countryName: String,
    @SerializedName("country_flag_url") val flag: String
)