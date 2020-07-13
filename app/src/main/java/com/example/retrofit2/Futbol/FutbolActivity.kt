package com.example.retrofit2.Futbol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2.R
import kotlinx.android.synthetic.main.activity_futbol.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FutbolActivity : AppCompatActivity() {

    val URLAPI = "http://api.football-data.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futbol)

        futbolActivity.layoutManager = LinearLayoutManager(this)
        futbolActivity.adapter = null

        var retrofitFutbol = Retrofit.Builder()
            .baseUrl(URLAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiFutbol=retrofitFutbol.create(ApiFutbol::class.java)

        var callFutbol=apiFutbol.getLugares()

        callFutbol.enqueue(object :Callback<Lugares>{
            override fun onFailure(call: Call<Lugares>, t: Throwable) {
                Log.e("TAG Falla",t.toString())
            }

            override fun onResponse(call: Call<Lugares>, response: Response<Lugares>) {
                for (res in response.body()!!.areas){
                    Log.d("Paises: ",res.name +" Lugar " + res.parentArea)
                }
                futbolActivity.adapter=FutbolAdapter(response.body()!!.areas)
            }

        })
    }
}

