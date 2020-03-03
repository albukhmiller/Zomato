package company.alex.com.zomato.domain.inretactors

import company.alex.com.zomato.domain.api.ApiServer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantInteractor @Inject constructor(private val apiServer: ApiServer) {

    fun getCategories() = apiServer.getRestaurantCategories()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

}