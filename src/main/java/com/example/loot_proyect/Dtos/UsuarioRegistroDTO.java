package com.example.loot_proyect.Dtos;


public record UsuarioRegistroDTO(
        String correo,
        String nombre,
        String apellido_p,
        String apellido_m,
        String contrasena,
        String num_telefono,
        String direccion
) {}