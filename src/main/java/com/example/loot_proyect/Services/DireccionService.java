package com.example.loot_proyect.Services;


import com.example.loot_proyect.Dtos.DireccionDTO;
import com.example.loot_proyect.Mappers.Mapper;
import com.example.loot_proyect.Repository.DireccionRepository;
import com.example.loot_proyect.model.DireccionEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

public class DireccionService {

    private DireccionRepository direccionRepository = new DireccionRepository();

    @Transactional
    public void agregarDireccion(DireccionDTO direccionDTO) throws Exception {
        if (direccionDTO == null) {
            throw new IllegalArgumentException("Direccion invalido");
        }
        DireccionEntity direccionEntity = Mapper.toDireccionEntity(direccionDTO);
        direccionRepository.agregarDireccion( direccionEntity);

    }

    public void eliminarDireccion(DireccionDTO direccionDTO) throws Exception {
        if (direccionDTO == null) {
            throw new IllegalArgumentException("Direccion invalido");
        }

        DireccionEntity direccionEntity = Mapper.toDireccionEntity(direccionDTO);
        direccionRepository.eliminarDireccion(direccionEntity);
    }

    @Transactional
    public DireccionDTO actualizarDireccion(DireccionDTO direccionDTO) throws Exception {
        if (direccionDTO == null) {
            throw new IllegalArgumentException("Direccion invalido");
        }

        DireccionEntity direccionEntity = Mapper.toDireccionEntity(direccionDTO);
        DireccionEntity direccionActualizada = direccionRepository.ActualizarDireccion(direccionEntity);

        return Mapper.toDireccionDTO(direccionActualizada);
    }
    @Transactional
    public DireccionDTO buscarDireccionPorId(DireccionDTO direccionDTO) throws Exception {
        if (direccionDTO == null) {
            throw new IllegalArgumentException("Direccion invalido");

        }
        DireccionEntity direccionEntity = Mapper.toDireccionEntity(direccionDTO);
        direccionRepository.buscarDirecciones(direccionEntity);
        return Mapper.toDireccionDTO(direccionEntity);
    }


}
