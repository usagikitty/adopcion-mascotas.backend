package com.AppMascotas.adopcion_mascotas.dtos

data class MascotaDTO(
    val nombre: String,
    val especie: String,
    val edad: Int,
    val descripcion: String,
    val disponible: Boolean = true
)