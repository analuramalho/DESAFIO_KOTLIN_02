package com.example.digitalhousefoods.detalhesPrato.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.detalhesRestaurante.view.DetalheRestauranteFragment
import com.squareup.picasso.Picasso

class DetalhePratoFragment : Fragment() {
    lateinit var pratoView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pratoView = inflater.inflate(R.layout.fragment_detalhe_prato, container, false)
        return pratoView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomePrato = pratoView.findViewById<TextView>(R.id.txtNomePrato_detalhePrato)
        nomePrato.text = arguments?.getString(DetalheRestauranteFragment.NOME)

        val imagemPrato = pratoView.findViewById<ImageView>(R.id.imagePrato_detalhesPrato)
        arguments?.getInt(DetalheRestauranteFragment.IMAGEM)?.let {
            Picasso.get()
                .load(it)
                .into(imagemPrato)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetalhePratoFragment()
    }
}