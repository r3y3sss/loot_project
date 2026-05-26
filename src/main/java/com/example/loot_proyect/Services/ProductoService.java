package com.example.loot_proyect.Services;

import com.example.loot_proyect.Repository.ProductoRepository;
import com.example.loot_proyect.Mappers.Mapper;
import com.example.loot_proyect.Dtos.ProductoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoService {

    private ProductoRepository productoRepository = new ProductoRepository();

    public void agregarProducto(ProductoDTO dto) {
        productoRepository.AgregarProducto(Mapper.toProductoEntity(dto));
    }

    public void actualizarProducto(ProductoDTO dto) {
        productoRepository.ActualizarProducto(Mapper.toProductoEntity(dto));
    }

    public void eliminarProducto(ProductoDTO dto) {
        productoRepository.EliminarProducto(Mapper.toProductoEntity(dto));
    }

    public List<ProductoDTO> buscarProducto() {
        return productoRepository.buscarProductos().stream()
                .map(Mapper::toProductoDTO)
                .collect(Collectors.toList());
    }

    public List<ProductoDTO> buscarNombre(String textoFiltro) {
        if (textoFiltro == null || textoFiltro.trim().isEmpty()) {
            return buscarProducto();
        }
        String texto = textoFiltro.toLowerCase();
        return buscarProducto().stream()
                .filter(p -> p.descripcion() != null && p.descripcion().toLowerCase().contains(texto))
                .collect(Collectors.toList());
    }
}