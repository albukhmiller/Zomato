package company.alex.com.zomato.datasources.remote.interseptors

import company.alex.com.zomato.datasources.remote.exceptions.AuthorizationException
import company.alex.com.zomato.datasources.remote.exceptions.InvalidInputException
import okhttp3.Interceptor
import okhttp3.Response

class ExceptionHandleInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var response = chain.proceed(chain.request())

        when (response.code) {
            400 -> throw  InvalidInputException("Invalid input")
            403 -> throw  AuthorizationException("Invalid auth token")
        }

        return response
    }
}