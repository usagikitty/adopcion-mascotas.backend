package com.AppMascotas.adopcion_mascotas.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "solicitudes_adopcion")
data class SolicitudAdopcion(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    val usuario: Usuario = Usuario(),

    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    val mascota: Mascota = Mascota(),

    @Column(nullable = false)
    val estado: String = "pendiente",

    @Column(nullable = false)
    val fechaSolicitud: LocalDateTime = LocalDateTime.now()
)