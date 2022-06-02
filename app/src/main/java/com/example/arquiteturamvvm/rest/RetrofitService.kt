package com.example.arquiteturamvvm.rest

import com.example.arquiteturamvvm.models.Live
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {

    //Base URL
    @GET("lista-lives.json")
    fun getAllLives(): Call<List<Live>>

    companion object {
        private val retrofitService : RetrofitService by lazy {  //Função lazy inicializa o objeto quando utilizado

            val retrofit = Retrofit.Builder()
                .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/") //URL de destino da API
                .addConverterFactory(GsonConverterFactory.create()) //Converter o dado JSON
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService{
            return retrofitService
        }

    }


}