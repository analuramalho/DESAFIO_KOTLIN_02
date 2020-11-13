package com.example.digitalhousefoods.detalhesRestaurante.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.digitalhousefoods.detalhesRestaurante.model.Cardapio
import com.example.digitalhousefoods.detalhesRestaurante.repository.CardapioRepository

class CardapioViewModel(
    private val repository: CardapioRepository
) : ViewModel() {

    val listaPratosData = MutableLiveData<List<Cardapio>>()

    fun obterCardapio() {
        repository.obterCardapio {
            listaPratosData.value = it
        }
    }

    class CardapioViewModelFactory(
        private val repository: CardapioRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CardapioViewModel(repository) as T
        }
    }
}