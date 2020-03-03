package company.alex.com.zomato.datasources.remote.interseptors

import company.alex.com.zomato.Constants
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader(Constants.AUTH_HEADER, "7eb199d4635a13793802d52d8a8dd46b") // token must be encrypted
                .build()
        )
    }
}