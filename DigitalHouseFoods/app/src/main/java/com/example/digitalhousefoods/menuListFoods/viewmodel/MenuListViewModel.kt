package com.example.digitalhousefoods.menuListFoods.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.digitalhousefoods.menuListFoods.model.Restaurantes
import com.example.digitalhousefoods.menuListFoods.repository.MenuListRepository

class MenuListViewModel(
    private val repository: MenuListRepository
) : ViewModel() {

    val listaRestaurantesData = MutableLiveData<List<Restaurantes>>()

    fun obterRestaurantes() {
        repository.obterRestaurantes {
            listaRestaurantesData.value = it
        }
    }

    class MenuListViewModelFactory(
        private val repository: MenuListRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MenuListViewModel(repository) as T
        }
    }


}