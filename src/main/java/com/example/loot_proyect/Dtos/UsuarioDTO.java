package Dtos;

import com.example.loot_proyect.model.DireccionEntity;
import java.time.LocalDate;

public record UsuarioDTO(int id_usuario, String correo, String nombre, LocalDate fecha_nacimiento,
                            String apellido_p, String apellido_m, String contrasena, String num_telefono) {
}
