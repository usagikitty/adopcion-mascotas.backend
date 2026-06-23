package com.AppMascotas.adopcion_mascotas.controllers

import com.AppMascotas.adopcion_mascotas.dtos.SolicitudAdopcionDTO
import com.AppMascotas.adopcion_mascotas.models.SolicitudAdopcion
import com.AppMascotas.adopcion_mascotas.services.SolicitudAdopcionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/solicitudes")
class SolicitudAdopcionController(private val solicitudService: SolicitudAdopcionService) {

    @GetMapping
    fun obtenerTodas(): ResponseEntity<List<SolicitudAdopcion>> {
        return ResponseEntity.ok(solicitudService.obtenerTodas())
    }

    @PostMapping
    fun crear(@RequestBody dto: SolicitudAdopcionDTO): ResponseEntity<SolicitudAdopcion> {
        return ResponseEntity.ok(solicitudService.crear(dto))
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<String> {
        solicitudService.eliminar(id)
        return ResponseEntity.ok("Solicitud eliminada")
    }
}