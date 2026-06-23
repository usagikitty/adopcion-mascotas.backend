package com.AppMascotas.adopcion_mascotas.services

import com.AppMascotas.adopcion_mascotas.dtos.UsuarioDTO
import com.AppMascotas.adopcion_mascotas.models.Usuario
import com.AppMascotas.adopcion_mascotas.repositories.UsuarioRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun obtenerTodos(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun obtenerPorId(id: Long): Usuario {
        return usuarioRepository.findById(id)
            .orElseThrow { RuntimeException("Usuario no encontrado") }
    }

    fun crear(dto: UsuarioDTO): Usuario {
        val emailExiste = usuarioRepository.findByEmail(dto.email).isPresent
        if (emailExiste) throw RuntimeException("El email ya está registrado")

        val passwordCifrado: String = passwordEncoder.encode(dto.password)!!
        val usuario = Usuario(
            nombre = dto.nombre,
            email = dto.email,
            password = passwordCifrado,
            telefono = dto.telefono
        )
        return usuarioRepository.save(usuario)
    }

    fun eliminar(id: Long) {
        usuarioRepository.deleteById(id)
    }
}