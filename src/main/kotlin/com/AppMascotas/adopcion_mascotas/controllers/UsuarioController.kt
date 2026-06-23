package com.AppMascotas.adopcion_mascotas.controllers

import com.AppMascotas.adopcion_mascotas.dtos.UsuarioDTO
import com.AppMascotas.adopcion_mascotas.models.Usuario
import com.AppMascotas.adopcion_mascotas.services.UsuarioService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val usuarioService: UsuarioService) {

    @GetMapping
    fun obtenerTodos(): ResponseEntity<List<Usuario>> {
        return ResponseEntity.ok(usuarioService.obtenerTodos())
    }

    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): ResponseEntity<Usuario> {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id))
    }

    @PostMapping
    fun crear(@RequestBody dto: UsuarioDTO): ResponseEntity<Usuario> {
        return ResponseEntity.ok(usuarioService.crear(dto))
    }

    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): ResponseEntity<String> {
        usuarioService.eliminar(id)
        return ResponseEntity.ok("Usuario eliminado")
    }
}