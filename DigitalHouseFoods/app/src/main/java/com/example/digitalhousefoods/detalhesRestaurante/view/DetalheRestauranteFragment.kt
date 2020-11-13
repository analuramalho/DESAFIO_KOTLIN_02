package com.example.digitalhousefoods.detalhesRestaurante.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.detalhesRestaurante.model.Cardapio
import com.example.digitalhousefoods.detalhesRestaurante.repository.CardapioRepository
import com.example.digitalhousefoods.detalhesRestaurante.viewmodel.CardapioViewModel
import com.example.digitalhousefoods.menuListFoods.view.MenuListFragment
import com.squareup.picasso.Picasso


class DetalheRestauranteFragment : Fragment() {
    lateinit var detalheView: View
    lateinit var viewModel: CardapioViewModel
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detalheView = inflater.inflate(R.layout.fragment_detalhe_restaurant, container, false)
        return detalheView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomeRestaurante =
            detalheView.findViewById<TextView>(R.id.txtNomeRestaurante_detalheRestaurante)
        nomeRestaurante.text = arguments?.getString(MenuListFragment.NOME_RESTAURANTE)

        val imagemRestaurante =
            detalheView.findViewById<ImageView>(R.id.imageRestaurante_detalhesRestaurante)
        arguments?.getInt(MenuListFragment.IMAGEM_RESTAURANTE)?.let {
            Picasso.get()
                .load(it)
                .into(imagemRestaurante)
        }

        viewModel = ViewModelProvider(
            this,
            CardapioViewModel.CardapioViewModelFactory(CardapioRepository(detalheView.context))
        ).get(CardapioViewModel::class.java)

        viewModel.listaPratosData.observe(viewLifecycleOwner, Observer {
            criarCardapio(it)
        })
        viewModel.obterCardapio()

    }

    private fun criarCardapio(lista: List<Cardapio>) {
        navController = Navigation.findNavController(detalheView)

        val viewManager = GridLayoutManager(detalheView.context, 2)
        val recyclerView = detalheView.findViewById<RecyclerView>(R.id.listaPratos)
        val menuAdapter = CardapioAdapter(lista) {

            val bundle = bundleOf(NOME to it.nome, IMAGEM to it.imagem)

            navController.navigate(R.id.detalhePratoFragment, bundle)
        }

        recyclerView.apply {
            layoutManager = viewManager
            adapter = menuAdapter
        }


    }

    companion object {

        fun newInstance() = DetalheRestauranteFragment()

        val NOME = "NOME_PRATO"
        val IMAGEM = "IMAGEM_PRATO"
    }
}
