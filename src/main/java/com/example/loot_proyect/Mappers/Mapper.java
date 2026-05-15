package Mappers;

import Dtos.CategoriaDTO;
import com.example.loot_proyect.model.CategoriaEntity;
import Dtos.DireccionDTO;
import com.example.loot_proyect.model.DireccionEntity;
import Dtos.ProductoDTO;
import com.example.loot_proyect.model.ProductoEntity;
import Dtos.UsuarioDTO;
import com.example.loot_proyect.model.UsuarioEntity;
import Dtos.VentaDTO;
import com.example.loot_proyect.model.VentaEntity;

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

            return new ProductoDTO(
                    entity.getId_producto(),
                    entity.getDescripcion(),
                    entity.getPrecio(),
                    entity.getImg()
            );
        }

        public static ProductoEntity toProductoEntity(ProductoDTO dto) {
            if (dto == null) return null;

            ProductoEntity entity = new ProductoEntity();
            entity.setId_producto(dto.id_producto());
            entity.setDescripcion(dto.descripcion());
            entity.setPrecio(dto.precio());
            entity.setImg(dto.img());

            return entity;
        }
    public static UsuarioDTO toUsuarioDTO (UsuarioEntity entity){
        if (entity == null) return null;

        return new UsuarioDTO(
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
    public static UsuarioEntity toUsuarioEntity (UsuarioDTO dto){
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
}
