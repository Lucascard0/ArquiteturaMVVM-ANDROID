package com.example.arquiteturamvvm.repositories

import com.example.arquiteturamvvm.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    /*Abstrai a chamada do RetrofitService para um repositório
    *Caso algum dia houvesse a necessidade de trocar a implementação do getAllLives, supondo que algum momento
    *não se utilizasse mais o Retrofit, a substituição ficaria muito mais simples, pois não teria que fazer alteração
    *no código todo do aplicativo, apenas no repositório
    */

    fun getAllLives() = retrofitService.getAllLives()
}