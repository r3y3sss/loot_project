package com.example.loot_proyect.Services;

import com.example.loot_proyect.Dtos.CategoriaDTO;
import com.example.loot_proyect.Mappers.Mapper;
import com.example.loot_proyect.Repository.CategoriaRepository;
import com.example.loot_proyect.model.CategoriaEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

public class CategoriaService {


  private CategoriaRepository categoriaRepository = new CategoriaRepository();

  @Transactional
    public void GuardarCategoria(CategoriaDTO  categoriaDTO) throws Exception {
      if (categoriaDTO == null){
          throw new Exception("categoria no puede ser nulo.");

      }
      categoriaRepository.agregarCategoria(Mapper.toCategoriaEntity(categoriaDTO));
  }
  @Transactional
    public CategoriaDTO buscarCategoria(CategoriaDTO  categoriaDTO) throws Exception {
      if (categoriaDTO == null ){
          throw new Exception("categoria no puede ser nulo.");

      }
      CategoriaEntity entity = Mapper.toCategoriaEntity(categoriaDTO);
      if (entity == null){
          throw new EntityNotFoundException("categoria no encontrada");
      }
      return  Mapper.toCategoriaDTO(entity);

  }

}

