package com.AppMascotas.adopcion_mascotas.services

import com.AppMascotas.adopcion_mascotas.dtos.MascotaDTO
import com.AppMascotas.adopcion_mascotas.models.Mascota
import com.AppMascotas.adopcion_mascotas.repositories.MascotaRepository
import org.springframework.stereotype.Service

@Service
class MascotaService(private val mascotaRepository: MascotaRepository) {

    fun obtenerTodas(): List<Mascota> {
        return mascotaRepository.findAll()
    }

    fun obtenerDisponibles(): List<Mascota> {
        return mascotaRepository.findByDisponible(true)
    }

    fun obtenerPorId(id: Long): Mascota {
        return mascotaRepository.findById(id)
            .orElseThrow { RuntimeException("Mascota no encontrada") }
    }

    fun crear(dto: MascotaDTO): Mascota {
        val mascota = Mascota(
            nombre = dto.nombre,
            especie = dto.especie,
            edad = dto.edad,
            descripcion = dto.descripcion,
            disponible = dto.disponible
        )
        return mascotaRepository.save(mascota)
    }

    fun eliminar(id: Long) {
        mascotaRepository.deleteById(id)
    }
}