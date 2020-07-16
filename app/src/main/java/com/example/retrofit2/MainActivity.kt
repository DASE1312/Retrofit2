package com.example.retrofit2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit2.Futbol.FutbolActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* un JSON es un objecto siempre entre llaves ->{}
        los objecto se escriben en clave valor ej:
        {"Nombre":"Diego"}
        {"trabajo":"Programador android"}

        *JSON ARRAY va entre corchetes->[]
        ["Kotlin","Java","Php"]

        {
        "nombre":"diego",
        "trabajo":"programador android",
        "lenguajes":["kotlin","java","php"]
        }

        Array[]
            "list"
                "dt"
                "main"
                    "temp"
                    "humidity"

        array"area"
        objecto "parentArea",name"
          */
        mainActivityBtApiFutbol.setOnClickListener({
            var intent=Intent(this,FutbolActivity::class.java)
            startActivity(intent)
        })
    }
}
