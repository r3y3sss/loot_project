package com.example.loot_proyect.Services;

import com.example.loot_proyect.Dtos.UsuarioLoginDTO;
import com.example.loot_proyect.Dtos.UsuarioRegistroDTO;
import com.example.loot_proyect.Dtos.UsuarioConsultaDTO;
import com.example.loot_proyect.Mappers.Mapper;
import com.example.loot_proyect.Repository.UsuarioRepository;
import com.example.loot_proyect.model.UsuarioEntity;

import java.util.List;
import java.util.ArrayList;

public class UsuarioService {
    private UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void registroUsuario(UsuarioRegistroDTO usuarioDTO) throws Exception {
        if (usuarioDTO == null) {
            throw new Exception("UsuarioEntity null");
        }
        usuarioRepository.agregarUsuario(Mapper.toUsuarioEntity(usuarioDTO));
    }

    public UsuarioEntity login(UsuarioLoginDTO usuarioLoginDTO) throws Exception {
        if (usuarioLoginDTO == null) {
            throw new Exception("Usuario No existe");
        }
        if (usuarioLoginDTO.correo() == null || usuarioLoginDTO.contrasena() == null) {
            throw new Exception("No hay datos registrados");
        }

        UsuarioEntity usuario = usuarioRepository.buscarCorreo(usuarioLoginDTO.correo());

        if (usuario == null) {
            throw new Exception("El usuario no existe");
        }
        if (!usuario.getContrasena().equals(usuarioLoginDTO.contrasena())) {
            throw new Exception("Contraseña incorrecta");
        }

        return usuario;
    }

    public List<UsuarioConsultaDTO> obtenerUsuarios() {
        List<UsuarioEntity> entidades = usuarioRepository.getAllUsuarios();
        List<UsuarioConsultaDTO> dtos = new ArrayList<>();
        for (UsuarioEntity entity : entidades) {
            dtos.add(Mapper.toUsuarioDTO(entity));
        }
        return dtos;
    }
}