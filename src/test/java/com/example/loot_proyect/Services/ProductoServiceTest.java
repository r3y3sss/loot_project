package com.example.loot_proyect.Services;

import com.example.loot_proyect.Dtos.ProductoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ProductoServiceTest {
    private ProductoService service;

    @BeforeEach
    void SetUp(){
        service = new ProductoService();
    }

    @Test
    void Testeo(){
        ProductoDTO producto = new ProductoDTO(0, "Pantalla", "Pantalla de 24 pulgadas",
                15000, "imagen.png");
        service.agregarProducto(producto);
        List<ProductoDTO> lista = service.buscarProducto();
        assertFalse(lista.isEmpty(), "lista vacia");
        boolean elproducto = lista.stream().anyMatch(p -> p.nombre().equals("Pantalla"));
        assertTrue(elproducto);
    }
}