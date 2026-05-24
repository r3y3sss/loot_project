package com.example.loot_proyect.Dtos;

import java.time.LocalDate;

public record UsuarioConsultaDTO(
        int id_usuario,
        String correo,
        String nombre,
        LocalDate fecha_nacimiento,
        String apellido_p,
        String apellido_m,
        String contrasena,
        String num_telefono)
{}
