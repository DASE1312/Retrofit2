package com.example.retrofit2.Tiempo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2.R
import kotlinx.android.synthetic.main.activity_tiempo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import java.util.*

class TiempoActivity : AppCompatActivity() {

    val URLAPI="https://samples.openweathermap.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo)

        tiempoActivity.layoutManager=LinearLayoutManager(this)
        tiempoActivity.adapter=null

        var retrofitTiempo=Retrofit.Builder()
            .baseUrl(URLAPI)
                //GsonConverterFactory compone y descompone el mismo sin uno hacer nada el json
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiTiempo=retrofitTiempo.create(ApiTiempo::class.java)
        var callTiempo=apiTiempo.getTiempo()
        callTiempo.enqueue(object:Callback<Metereologia>{
            override fun onFailure(call: Call<Metereologia>, t: Throwable) {
               Log.e("TAG fallo",t.toString())
            }

            override fun onResponse(call: Call<Metereologia>, response: Response<Metereologia>) {
                for (res in response.body()!!.list){
                    Log.d("TAG Respuestas: ",res.main.temp)
                }
                tiempoActivity.adapter=TiempoAdapter(response.body()!!.list)
            }

        })

    }
}
