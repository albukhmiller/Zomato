package company.alex.com.zomato.di.modules

import company.alex.com.zomato.Constants
import company.alex.com.zomato.datasources.remote.interseptors.ExceptionHandleInterceptor
import company.alex.com.zomato.datasources.remote.interseptors.RequestInterceptor
import company.alex.com.zomato.domain.api.ApiServer
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): ApiServer = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor())
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(ExceptionHandleInterceptor())
                .build()
        )
        .build()
        .create(ApiServer::class.java)
}