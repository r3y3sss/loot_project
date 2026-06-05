package com.example.loot_proyect.Services;

import com.example.loot_proyect.Dtos.CategoriaDTO;
import com.example.loot_proyect.Dtos.HistorialDTO;
import com.example.loot_proyect.Dtos.VentaDTO;
import com.example.loot_proyect.Mappers.Mapper;
import com.example.loot_proyect.Repository.VentaRepository;
import com.example.loot_proyect.model.VentaEntity;

import java.util.List;

public class VentaService {

    private VentaRepository ventaRepository = new VentaRepository();

    public void GuardarVenta(VentaDTO ventaDTO) throws Exception {
        if (ventaDTO == null) {
            throw new IllegalArgumentException("categoria no puede ser nulo.");
        }
        VentaEntity ventaEntity = Mapper.toVentaEntity(ventaDTO);
        ventaRepository.registroVenta(ventaEntity);
    }
    public void EliminarVenta(VentaDTO ventaDTO) throws Exception {
        if (ventaDTO == null) {
            throw new IllegalArgumentException("categoria no puede ser nulo.");

        }
        VentaEntity ventaEntity = Mapper.toVentaEntity(ventaDTO);
        ventaRepository.registroVenta(ventaEntity);

    }
    public VentaDTO ActualizarVenta(VentaDTO ventaDTO) throws Exception {
        if (ventaDTO == null) {
            throw new IllegalArgumentException("categoria no puede ser nulo.");

        }
        VentaEntity ventaEntity = Mapper.toVentaEntity(ventaDTO);
        ventaRepository.actualizarVenta(ventaEntity);

        return ventaDTO;
    }

    public List<HistorialDTO> obtenerHistorialUsuario(int idUsuario) {

        List<VentaEntity> ventas = ventaRepository.obtenerVentasPorUsuario(idUsuario);

        return ventas.stream()
                .map(v -> new HistorialDTO(
                        v.getFecha_venta().toString(),
                        v.getProducto().getNombre(),
                        v.getPrecio_venta()
                ))
                .toList();
    }

}
