package com.AppMascotas.adopcion_mascotas.repositories

import com.AppMascotas.adopcion_mascotas.models.SolicitudAdopcion
import org.springframework.data.jpa.repository.JpaRepository

interface SolicitudAdopcionRepository : JpaRepository<SolicitudAdopcion, Long> {
    fun findByUsuarioId(usuarioId: Long): List<SolicitudAdopcion>
}