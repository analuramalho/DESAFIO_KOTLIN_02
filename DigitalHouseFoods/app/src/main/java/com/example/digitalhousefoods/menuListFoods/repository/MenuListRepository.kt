package com.example.digitalhousefoods.menuListFoods.repository

import android.content.Context
import com.example.digitalhousefoods.menuListFoods.model.Restaurantes

class MenuListRepository(private val context: Context) {
    fun obterRestaurantes(callback: (restaurantes: List<Restaurantes>) -> Unit) {
        callback.invoke(
            listOf(
                Restaurantes(
                    "Tony Roma's",
                    "Av. Lavandisca,717 - Indianópolis, São Paulo",
                    "Fecha às 22:00"
                ),
                Restaurantes(
                    "Aoyoma - Moema",
                    "Alameda dos Arapanés, 532 - Moema",
                    "Fecha às 00:00"
                ),
                Restaurantes(
                    "Outback - Moema",
                    "Av. Moaci, 187, 187 - Moema, São Paulo",
                    "Fecha às 00:00"
                ),
                Restaurantes(
                    "Sí Señor!",
                    "Alameda Jauaperi, 626 - Moema",
                    "Fecha às 01:00"
                )
            )
        )
    }

}