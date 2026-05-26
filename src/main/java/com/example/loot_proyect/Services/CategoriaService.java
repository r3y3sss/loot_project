package com.example.loot_proyect.Services;

import com.example.loot_proyect.Dtos.CategoriaDTO;
import com.example.loot_proyect.Mappers.Mapper;
import com.example.loot_proyect.Repository.CategoriaRepository;
import com.example.loot_proyect.model.CategoriaEntity;
import jakarta.persistence.EntityNotFoundException;

public class CategoriaService {

  private CategoriaRepository categoriaRepository = new CategoriaRepository();

  public void guardarCategoria(CategoriaDTO categoriaDTO) throws Exception {
    if (categoriaDTO == null) {
      throw new Exception("Categoria no puede ser nula.");
    }
    categoriaRepository.agregarCategoria(Mapper.toCategoriaEntity(categoriaDTO));
  }

  public CategoriaDTO buscarCategoria(CategoriaDTO categoriaDTO) throws Exception {
    if (categoriaDTO == null) {
      throw new Exception("Categoria no puede ser nula.");
    }
    CategoriaEntity entity = Mapper.toCategoriaEntity(categoriaDTO);
    if (entity == null) {
      throw new EntityNotFoundException("Categoria no encontrada");
    }
    return Mapper.toCategoriaDTO(entity);
  }
}