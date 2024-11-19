package com.example.newsappxml.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
//كده عايشة علطول فال ابلكيشن كله مش كل شوية اكريت اوبجكت
@InstallIn(SingletonComponent::class)
object networkModulue {

    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        val logging= HttpLoggingInterceptor{
            Log.e("api",it) }
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            return logging
    }
    @Provides
    fun provideOkHttpclinet(httpLoggingInterceptor:HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
    @Provides
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Provides
    fun provideRetrofit(okHttpClient:OkHttpClient,gsonConverterFactory: GsonConverterFactory):Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    fun provideWebServices(retrofit: Retrofit):WebServices{
        return retrofit.create(WebServices::class.java)
    }
}

/*{
     val logging= HttpLoggingInterceptor{ Log.e("api",it) }
         logging.setLevel(HttpLoggingInterceptor.Level.BODY)

      val okHttpClient= OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

      val retrofit=Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .client( okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

      fun getNewsServices():WebServices{
        return retrofit.create(WebServices::class.java)}
}*/