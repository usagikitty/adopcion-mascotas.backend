package com.AppMascotas.adopcion_mascotas.services

import com.AppMascotas.adopcion_mascotas.dtos.SolicitudAdopcionDTO
import com.AppMascotas.adopcion_mascotas.models.SolicitudAdopcion
import com.AppMascotas.adopcion_mascotas.repositories.MascotaRepository
import com.AppMascotas.adopcion_mascotas.repositories.SolicitudAdopcionRepository
import com.AppMascotas.adopcion_mascotas.repositories.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class SolicitudAdopcionService(
    private val solicitudRepository: SolicitudAdopcionRepository,
    private val usuarioRepository: UsuarioRepository,
    private val mascotaRepository: MascotaRepository
) {

    fun obtenerTodas(): List<SolicitudAdopcion> {
        return solicitudRepository.findAll()
    }

    fun crear(dto: SolicitudAdopcionDTO): SolicitudAdopcion {
        val usuario = usuarioRepository.findById(dto.usuarioId)
            .orElseThrow { RuntimeException("Usuario no encontrado") }

        val mascota = mascotaRepository.findById(dto.mascotaId)
            .orElseThrow { RuntimeException("Mascota no encontrada") }

        if (!mascota.disponible) throw RuntimeException("La mascota ya fue adoptada")

        val solicitud = SolicitudAdopcion(
            usuario = usuario,
            mascota = mascota,
            estado = "pendiente"
        )
        return solicitudRepository.save(solicitud)
    }

    fun eliminar(id: Long) {
        solicitudRepository.deleteById(id)
    }
}