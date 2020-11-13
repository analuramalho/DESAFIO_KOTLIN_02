package com.example.digitalhousefoods.menuListFoods.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.menuListFoods.model.Restaurantes
import com.example.digitalhousefoods.menuListFoods.repository.MenuListRepository
import com.example.digitalhousefoods.menuListFoods.viewmodel.MenuListViewModel


class MenuListFragment : Fragment() {
    lateinit var menuView: View
    lateinit var viewModel: MenuListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        menuView = inflater.inflate(R.layout.fragment_menu_list, container, false)

        viewModel = ViewModelProvider(
            this,
            MenuListViewModel.MenuListViewModelFactory(MenuListRepository(menuView.context))
        ).get(MenuListViewModel::class.java)

        viewModel.listaRestaurantesData.observe(viewLifecycleOwner, Observer {
            criarLista(it)
        })
        viewModel.obterRestaurantes()

        return menuView
    }

    private fun criarLista(lista: List<Restaurantes>) {
        val viewManager = LinearLayoutManager(menuView.context)
        val recyclerView = menuView.findViewById<RecyclerView>(R.id.minhaLista)
        val menuAdapter = MenuListAdapter(lista)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = menuAdapter
        }
    }

/*    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel=ViewModelProvider(
            this,
            MenuListViewModel.MenuListViewModelFactory(MenuListRepository())
        ).get(MenuListViewModel::class.java)

        viewModel.listaRestaurantesData.observe(viewLifecycleOwner, Observer {
            menuView.findViewById<TextView>(R.id.txtNomeRestaurante).text = it[0].nome
        })
    }*/

    companion object {
        @JvmStatic
        fun newInstance() = MenuListFragment()
    }
}