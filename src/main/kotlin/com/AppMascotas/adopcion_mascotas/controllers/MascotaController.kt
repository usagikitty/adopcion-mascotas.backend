package com.AppMascotas.adopcion_mascotas.controllers

import com.AppMascotas.adopcion_mascotas.dtos.MascotaDTO
import com.AppMascotas.adopcion_mascotas.models.Mascota
import com.AppMascotas.adopcion_mascotas.services.MascotaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mascotas")
class MascotaController(private val mascotaService: MascotaService) {

    @GetMapping
    fun obtenerTodas(): ResponseEntity<List<Mascota>> {
        return ResponseEntity.ok(mascotaService.obtenerTodas())
    }

    @GetMapping("/disponibles")
    fun obtenerDisponibles(): ResponseEntity<List<Mascota>> {
        return ResponseEntity.ok(mascotaService.obtenerDisponibles())
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<Mascota> {
        return ResponseEntity.ok(mascotaService.obtenerPorId(id))
    }

    @PostMapping
    fun crear(@RequestBody dto: MascotaDTO): ResponseEntity<Mascota> {
        return ResponseEntity.ok(mascotaService.crear(dto))
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<String> {
        mascotaService.eliminar(id)
        return ResponseEntity.ok("Mascota eliminada")
    }
}