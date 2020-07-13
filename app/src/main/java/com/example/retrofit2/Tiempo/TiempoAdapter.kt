package com.example.retrofit2.Tiempo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2.R
import kotlinx.android.synthetic.main.list_item_tiempo.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TiempoAdapter (val metereologia: ArrayList<Tiempo>):
    RecyclerView.Adapter<TiempoAdapter.TiempoViewHolder>() {
    class TiempoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindTiempo(tiempo:Tiempo){
            var date=Date(tiempo.dt.toLong()*1000)
            var sdf=SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            var tiempo1=sdf.format(date)
            Log.d("TAG TiempoAdapter: ",tiempo1)

            itemView.listFecha.text=tiempo1
            itemView.listHumedad.text=tiempo.main.humidity
            itemView.listTemperatura.text=tiempo.main.temp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiempoViewHolder {
        var layoutInflate=LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_tiempo,parent,false)
        return TiempoViewHolder(layoutInflate)
    }

    override fun getItemCount(): Int {
       return  metereologia.size
    }

    override fun onBindViewHolder(holder: TiempoViewHolder, position: Int) {
        var itemTiempo=metereologia[position]
        holder.bindTiempo(itemTiempo)
    }
}