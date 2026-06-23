package com.AppMascotas.adopcion_mascotas.dtos

data class UsuarioDTO(
    val nombre: String,
    val email: String,
    val password: String,
    val telefono: String
)