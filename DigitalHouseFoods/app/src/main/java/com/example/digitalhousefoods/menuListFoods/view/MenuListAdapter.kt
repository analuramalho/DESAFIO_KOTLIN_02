package com.example.digitalhousefoods.menuListFoods.view

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.menuListFoods.model.Restaurantes

class MenuListAdapter(private val dataSet: List<Restaurantes>) :
    RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>() {

    class MenuListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nome: TextView = view.findViewById(R.id.txtNomeRestaurante)
        private val endereco: TextView = view.findViewById(R.id.txtEndereco)
        private val funcionamento: TextView = view.findViewById(R.id.txtFuncionamento)

        fun bind(restaurantes: Restaurantes) {

            nome.text = restaurantes.nome
            endereco.text = restaurantes.endereco
            funcionamento.text = restaurantes.funcionamento
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
    }

    override fun getItemCount() = dataSet.size

}