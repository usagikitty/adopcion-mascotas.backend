package com.AppMascotas.adopcion_mascotas.models

import jakarta.persistence.*

@Entity
@Table(name = "mascotas")
data class Mascota(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val nombre: String = "",

    @Column(nullable = false)
    val especie: String = "",

    @Column(nullable = false)
    val edad: Int = 0,

    @Column(nullable = false)
    val descripcion: String = "",

    @Column(nullable = false)
    val disponible: Boolean = true
)