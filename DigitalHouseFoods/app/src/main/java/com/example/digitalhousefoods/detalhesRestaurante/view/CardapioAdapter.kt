package com.example.digitalhousefoods.detalhesRestaurante.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.detalhesRestaurante.model.Cardapio
import com.squareup.picasso.Picasso

class CardapioAdapter(
    private val dataSet:List<Cardapio>,
    private val clickListener: (Cardapio) -> Unit
) :
    RecyclerView.Adapter<CardapioAdapter.CardapioViewHolder>(){

    class CardapioViewHolder(view: View):RecyclerView.ViewHolder(view) {

        private val nomePrato: TextView = view.findViewById(R.id.txtNomePrato)
        private val imagePrato : ImageView =view.findViewById(R.id.imagePrato)

        fun bind(cardapio: Cardapio) {
            nomePrato.text=cardapio.nome
            Picasso.get()
                .load(cardapio.imagem)
                .into(imagePrato)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_pratos, parent, false)

        return CardapioViewHolder(view)
    }

    override fun getItemCount()=dataSet.size

    override fun onBindViewHolder(holder: CardapioViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener{clickListener(dataSet[position])}
    }

}
