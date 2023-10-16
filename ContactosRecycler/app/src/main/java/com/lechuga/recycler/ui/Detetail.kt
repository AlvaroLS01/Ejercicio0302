package com.pablo.reciclar1.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pablo.reciclar1.R
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.pablo.reciclar1.databinding.ActivityDetetailBinding
import com.pablo.reciclar1.model.Persona
import java.lang.IllegalStateException

class Detetail : AppCompatActivity() {

    companion object {
        const val PERSONA = "persona"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetetailBinding.inflate(layoutInflater).apply {
            setContentView(root)
           val persona = intent.getParcelableExtra<Persona>(PERSONA)?:throw IllegalStateException()
            nombre.text = persona.nombre
            Glide.with(url).load(persona.urlImagen).into(url)

            btnEmail.setOnClickListener {
                val emailIntent = Intent(Intent.ACTION_SENDTO)
                emailIntent.data = Uri.parse("mailto:")
                emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(persona.email))
                emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(persona.email))

                startActivity(emailIntent)
            }

            btnLlamar.setOnClickListener {
                val callIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${persona.telefono}")
                }
                startActivity(callIntent)
            }



        }
    }
}