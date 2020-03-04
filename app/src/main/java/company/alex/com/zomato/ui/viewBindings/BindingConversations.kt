package company.alex.com.zomato.ui.viewBindings

import androidx.databinding.BindingConversion
import company.alex.com.zomato.datasources.remote.dtos.city.CityInfoDto
import company.alex.com.zomato.models.searchCity.CityInfo

object BindingConversations {

    @JvmStatic
    @BindingConversion
    fun cityInfoToString(cityInfo: CityInfo?): String {
        if (cityInfo == null)
            return ""

        return "Данные о городе:\nназвание =  ${cityInfo.name},\n\nстрана = ${cityInfo.countryName},\n URL для флага = ${cityInfo.flag}"
    }
}