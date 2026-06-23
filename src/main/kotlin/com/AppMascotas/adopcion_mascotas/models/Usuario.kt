package com.AppMascotas.adopcion_mascotas.models

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
data class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String = "",

    @Column(name = "correo", nullable = false, unique = true)
    val email: String = "",

    @Column(nullable = false)
    val password: String = "",

    @Column(nullable = false)
    val telefono: String = ""
)