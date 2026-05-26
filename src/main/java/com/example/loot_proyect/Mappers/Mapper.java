package com.example.loot_proyect.Mappers;

import com.example.loot_proyect.Dtos.*;
import com.example.loot_proyect.model.*;


public class Mapper {
    public static CategoriaDTO toCategoriaDTO(CategoriaEntity entity) {
        if (entity == null) return null;

        return new CategoriaDTO(
                entity.getId_categoria(), entity.getNombre()
        );
    }

    public static CategoriaEntity toCategoriaEntity(CategoriaDTO dto) {
        if (dto == null) return null;

        CategoriaEntity entity = new CategoriaEntity();
        entity.setNombre(dto.nombre());
        entity.setId_categoria(dto.id_categoria());
        return entity;
    }

    public static DireccionDTO toDireccionDTO(DireccionEntity entity) {
        if (entity == null) return null;

        return new DireccionDTO(
                entity.getId_direccion(), entity.getCalle(), entity.getColonia(), entity.getCp(),
                entity.getMunicipio(), entity.getEstado()
        );
    }

    public static DireccionEntity toDireccionEntity(DireccionDTO dto) {
        if (dto == null) return null;

        DireccionEntity entity = new DireccionEntity();
        entity.setId_direccion(dto.id_direccion());
        entity.setCalle(dto.calle());
        entity.setColonia(dto.colonia());
        entity.setCp(dto.cp());
        entity.setEstado(dto.estado());

        return entity;
    }

    public static ProductoDTO toProductoDTO(ProductoEntity entity) {
        if (entity == null) return null;

        String nombreVendedor = "";
        String telefonoVendedor = "";

        if (entity.getUsuario() != null) {
            nombreVendedor = entity.getUsuario().getNombre() + " " + entity.getUsuario().getApellido_p();
            telefonoVendedor = entity.getUsuario().getNumTelefono();
        }

        return new ProductoDTO(
                entity.getId_producto(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getPrecio(),
                entity.getImg(),
                nombreVendedor,
                telefonoVendedor
        );
    }

        public static ProductoEntity toProductoEntity(ProductoDTO dto) {
            if (dto == null) return null;

            ProductoEntity entity = new ProductoEntity();
            entity.setId_producto(dto.id_producto());
            entity.setNombre(dto.nombre());
            entity.setDescripcion(dto.descripcion());
            entity.setPrecio(dto.precio());
            entity.setImg(dto.img());

            return entity;
        }
    public static UsuarioConsultaDTO toUsuarioDTO (UsuarioEntity entity){
        if (entity == null) return null;

        return new UsuarioConsultaDTO(
                entity.getId_usuario(),
                entity.getCorreo(),
                entity.getNombre(),
                entity.getFecha_nacimiento(),
                entity.getApellido_p(),
                entity.getApellido_m(),
                entity.getContrasena(),
                entity.getNumTelefono()
        );
        }
    public static UsuarioEntity toUsuarioEntity (UsuarioConsultaDTO dto){
        if (dto == null) return null;

        UsuarioEntity entity = new UsuarioEntity();

        entity.setId_usuario(dto.id_usuario());
        entity.setCorreo(dto.correo());
        entity.setNombre(dto.nombre());
        entity.setFecha_nacimiento(dto.fecha_nacimiento());
        entity.setApellido_p(dto.apellido_p());
        entity.setApellido_m(dto.apellido_m());
        entity.setContrasena(dto.contrasena());
        entity.setNumTelefono(dto.num_telefono());
        return entity;
    }
    public static VentaDTO toDTO (VentaEntity entity){
        return new VentaDTO(
                entity.getId_venta(),
                entity.getFecha_venta(),
                entity.getCantidad_producto(),
                entity.getPrecio_venta()
        );
    }
    public static VentaEntity toVentaEntity (VentaDTO dto){

        VentaEntity entity = new VentaEntity();

        entity.setId_venta(dto.id_venta());
        entity.setFecha_venta(dto.fecha_venta());
        entity.setCantidad_producto(dto.cantidad_producto());
        entity.setPrecio_venta(dto.precio_venta());

        return entity;
    }

    public static UsuarioEntity toUsuarioEntity(UsuarioRegistroDTO dto) {
        if (dto == null) return null;

        UsuarioEntity entity = new UsuarioEntity();
        entity.setCorreo(dto.correo());
        entity.setNombre(dto.nombre());
        entity.setApellido_p(dto.apellido_p());
        entity.setApellido_m(dto.apellido_m());
        entity.setContrasena(dto.contrasena());
        entity.setNumTelefono(dto.num_telefono());
        return entity;
    }
}
