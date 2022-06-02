package com.example.arquiteturamvvm.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.arquiteturamvvm.repositories.MainRepository
import java.lang.IllegalArgumentException

/*
* Poderiamos utilizar o ViewModelProviders diretamente, mas como nossa ViewModel
* possui um construtor com argumentos, deve-se criar uma Factory
*/

class MainViewModelFatory constructor(private val repository: MainRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository) as T
        } else{
            throw IllegalArgumentException("ViewModel não encontrada")
        }

    }

}