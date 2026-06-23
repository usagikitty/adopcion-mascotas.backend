package com.AppMascotas.adopcion_mascotas.repositories

import com.AppMascotas.adopcion_mascotas.models.Mascota
import org.springframework.data.jpa.repository.JpaRepository

interface MascotaRepository : JpaRepository<Mascota, Long> {
    fun findByDisponible(disponible: Boolean): List<Mascota>
}