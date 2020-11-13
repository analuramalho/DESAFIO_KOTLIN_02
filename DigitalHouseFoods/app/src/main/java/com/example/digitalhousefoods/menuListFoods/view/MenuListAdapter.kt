package com.example.digitalhousefoods.menuListFoods.view

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.menuListFoods.model.Restaurantes
import com.squareup.picasso.Picasso


class MenuListAdapter(
    private val dataSet: List<Restaurantes>,
    private val clickListener: (Restaurantes) -> Unit
) :
    RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>() {

    class MenuListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nome: TextView = view.findViewById(R.id.txtNomeRestaurante)
        private val endereco: TextView = view.findViewById(R.id.txtEndereco)
        private val funcionamento: TextView = view.findViewById(R.id.txtFuncionamento)
        private val image :ImageView=view.findViewById(R.id.imageMenu)

        fun bind(restaurantes: Restaurantes) {

            nome.text = restaurantes.nome
            endereco.text = restaurantes.endereco
            funcionamento.text = restaurantes.funcionamento
            Picasso.get()
                .load(restaurantes.imageUrl)
                .into(image)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuListAdapter.MenuListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)

        return MenuListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuListAdapter.MenuListViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener{clickListener(dataSet[position])}
    }

    override fun getItemCount() = dataSet.size

}