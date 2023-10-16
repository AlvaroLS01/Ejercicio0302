package com.pablo.reciclar1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Persona(
    val nombre: String,
    val email : String,
    val telefono: String,
    val urlImagen: String ):Parcelable

