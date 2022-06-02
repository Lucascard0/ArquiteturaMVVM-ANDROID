package com.example.arquiteturamvvm.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.arquiteturamvvm.models.Live
import com.example.arquiteturamvvm.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*Na configuração da classe ViewModel, deve-se criar uma classe e estender o ViewModel
*É na classe ViewModel que fica a lógica de negócios e implementação de chamadas de API.
* No constructor do ViewModel, precisa passar o repositório de dados criado anteriormente para lidar com os dados
*/

/*Está sendo utilizado os dados Live para atualizar os dados para a UI, como o live data respeita o cilco de vida do android,
* isso significa que ele não invocará seu retorno de chamada do observador, a menos que a activity ou fragment tenha passado
* pelo onStart, e não tenha passado pelo onStop. E o LiveData removerá automaticamente o observador quando o host receber onDestroy
* */

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives(){
        //Utilizando o objeto call para criar uma tarefa assíncrona dentro de uma Thread de forma automática
        val request = repository.getAllLives()
        request.enqueue(object : Callback<List<Live>>{
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
                //Quando houver uma resposta
                liveList.postValue(response.body())

            }

            override fun onFailure(call: Call<List<Live>>, t: Throwable) {
                // Quando houver uma falha na chamada
                errorMessage.postValue(t.message)

            }

        })
    }
}