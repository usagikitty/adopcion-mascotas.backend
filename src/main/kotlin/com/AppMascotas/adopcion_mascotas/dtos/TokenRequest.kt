package com.AppMascotas.adopcion_mascotas.dtos

data class TokenRequest(
    val email: String,
    val password: String
)