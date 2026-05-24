package com.example.loot_proyect.Dtos;

import java.time.LocalDate;

public record UsuarioRegistroDTO(
        String correo,
        String nombre,
        String apellido_p,
        String apellido_m,
        String contrasena,
        String num_telefono,
        LocalDate fecha_nacimiento
) {}