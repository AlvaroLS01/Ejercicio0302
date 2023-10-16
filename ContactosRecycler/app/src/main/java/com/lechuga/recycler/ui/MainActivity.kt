package com.pablo.reciclar1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pablo.reciclar1.databinding.ActivityMainBinding
import com.pablo.reciclar1.model.Persona


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recycle.adapter = PersonaAdapter(personas){ persona ->
                val intent = Intent(this@MainActivity, Detetail::class.java)
                intent.putExtra(Detetail.PERSONA, persona)
                startActivity(intent)
            }
        }


    }

    private val personas = (1..100).map {
        Persona("Persona $it", "email $it@gmail.com", "$it", "https://loremflickr.com/240/320/paris?lock=$it")
    }
}