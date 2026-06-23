package com.AppMascotas.adopcion_mascotas.controllers

import com.AppMascotas.adopcion_mascotas.dtos.TokenRequest
import com.AppMascotas.adopcion_mascotas.dtos.TokenResponse
import com.AppMascotas.adopcion_mascotas.repositories.UsuarioRepository
import com.AppMascotas.adopcion_mascotas.security.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val usuarioRepository: UsuarioRepository,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/login")
    fun login(@RequestBody request: TokenRequest): ResponseEntity<TokenResponse> {
        val usuario = usuarioRepository.findByEmail(request.email)
            .orElseThrow { RuntimeException("Usuario no encontrado") }

        if (!passwordEncoder.matches(request.password, usuario.password)) {
            throw RuntimeException("Contraseña incorrecta")
        }

        val token = jwtUtil.generarToken(usuario.email)
        return ResponseEntity.ok(TokenResponse(token))
    }
}