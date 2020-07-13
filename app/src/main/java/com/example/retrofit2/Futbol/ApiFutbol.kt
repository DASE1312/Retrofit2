package com.example.retrofit2.Futbol


import retrofit2.Call
import retrofit2.http.GET


interface ApiFutbol {
    @GET("v2/areas")
    abstract fun getLugares():Call<Lugares>

}