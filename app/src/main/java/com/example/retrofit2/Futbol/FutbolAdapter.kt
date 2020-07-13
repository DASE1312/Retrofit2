package com.example.retrofit2.Futbol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import kotlinx.android.synthetic.main.list_item_paises.view.*

class FutbolAdapter (val resultado:ArrayList<Partido>):
    RecyclerView.Adapter<FutbolAdapter.FutbolViewHolder>() {

    class FutbolViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bindPartido(partido: Partido){
            itemView.listPais.text=partido.name
            itemView.listContinent.text=partido.parentArea

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutbolViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_paises,parent,false)
        return FutbolViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
       return resultado.size
    }

    override fun onBindViewHolder(holder: FutbolViewHolder, position: Int) {
        var itemPartido=resultado[position]
        holder.bindPartido(itemPartido)
    }
}