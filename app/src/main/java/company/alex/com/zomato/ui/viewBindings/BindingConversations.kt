package company.alex.com.zomato.ui.viewBindings

import androidx.databinding.BindingConversion
import company.alex.com.zomato.datasources.remote.dtos.city.CityInfoDto

object BindingConversations {

    @JvmStatic
    @BindingConversion
    fun cityInfoToString(cityInfoDto: CityInfoDto?): String {
        if (cityInfoDto == null)
            return ""

        return "Данные о городе:\nназвание =  ${cityInfoDto.name},\n\nстрана = ${cityInfoDto.countryName},\n URL для флага = ${cityInfoDto.flag}"
    }
}