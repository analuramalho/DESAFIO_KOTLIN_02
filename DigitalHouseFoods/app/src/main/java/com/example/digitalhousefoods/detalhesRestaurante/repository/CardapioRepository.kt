package com.example.digitalhousefoods.detalhesRestaurante.repository

import android.content.Context
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.detalhesRestaurante.model.Cardapio

class CardapioRepository(private val context: Context) {
    fun obterCardapio(callback: (listacardapio: List<Cardapio>) -> Unit) {
        callback.invoke(
            listOf(
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                ),
                Cardapio(
                    "Salada com Molho Gengibre", R.drawable.restaurante2
                )
            )
        )
    }
}