package com.example.digitalhousefoods.menuListFoods.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.menuListFoods.model.Restaurantes
import com.example.digitalhousefoods.menuListFoods.repository.MenuListRepository
import com.example.digitalhousefoods.menuListFoods.viewmodel.MenuListViewModel
import com.google.android.material.card.MaterialCardView


class MenuListFragment : Fragment() {
    lateinit var menuView: View
    lateinit var viewModel: MenuListViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menuView = inflater.inflate(R.layout.fragment_menu_list, container, false)
        return menuView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MenuListViewModel.MenuListViewModelFactory(MenuListRepository(menuView.context))
        ).get(MenuListViewModel::class.java)

        viewModel.listaRestaurantesData.observe(viewLifecycleOwner, Observer {
            criarLista(it)
        })
        viewModel.obterRestaurantes()


    }

    private fun criarLista(lista: List<Restaurantes>) {
        navController = Navigation.findNavController(menuView)

        val viewManager = LinearLayoutManager(menuView.context)
        val recyclerView = menuView.findViewById<RecyclerView>(R.id.minhaLista)
        val menuAdapter = MenuListAdapter(lista) {

            val bundle = bundleOf(NOME_RESTAURANTE to it.nome, IMAGEM_RESTAURANTE to it.imageUrl)
            navController.navigate(R.id.DetalheRestauranteFragment, bundle)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = menuAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MenuListFragment()

        val NOME_RESTAURANTE = "NOME"
        val IMAGEM_RESTAURANTE = "IMAGEM"
    }
}