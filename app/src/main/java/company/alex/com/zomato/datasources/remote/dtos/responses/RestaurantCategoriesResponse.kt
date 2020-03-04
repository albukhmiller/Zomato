package company.alex.com.zomato.datasources.remote.dtos.responses

import company.alex.com.zomato.models.restaurant.CategoryDto

data class RestaurantCategoriesResponse(val categories: List<CategoryDto>)