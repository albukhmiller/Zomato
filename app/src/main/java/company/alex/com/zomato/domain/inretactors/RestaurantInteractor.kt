package company.alex.com.zomato.domain.inretactors

import company.alex.com.zomato.datasources.remote.restaurants.RestaurantRemoteDataSource
import company.alex.com.zomato.models.restaurant.Category
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantInteractor @Inject constructor(private val dataSource: RestaurantRemoteDataSource) {

    fun getCategories() = dataSource.getCategories().toFlowable(BackpressureStrategy.LATEST)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .map { result ->
            val categories = mutableListOf<Category>()
            result.categories.forEach { result ->
                categories.add(
                    Category(
                        result.categories.id,
                        result.categories.name
                    )
                )
            }
            return@map categories

        }
}
