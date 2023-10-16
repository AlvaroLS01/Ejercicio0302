package com.pablo.reciclar1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pablo.reciclar1.R
import com.pablo.reciclar1.databinding.PersonLayoutBinding
import com.pablo.reciclar1.model.Persona


class PersonaAdapter(val personas: List<Persona>, val listener : (Persona) -> Unit):
    RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(personas[position])
        val persona = personas[position]
        holder.bind(persona)
        holder.itemView.setOnClickListener { listener(persona) }


    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val binding = PersonLayoutBinding.bind(view)
        fun bind(persona: Persona) {
            binding.nombre.text = persona.nombre
            binding.mail.text = persona.email
            binding.telefono.text = persona.telefono
            Glide.with(binding.url).load(persona.urlImagen).into(binding.url)

        }
    }

}