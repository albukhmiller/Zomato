package company.alex.com.zomato.datasources.models.restaurant

import com.google.gson.annotations.SerializedName

data class Data(@SerializedName("categories") val categories: List<Category>) {
}