package Dtos;

import java.time.LocalDate;

public record VentaDTO(int id_venta, LocalDate fecha_venta, int cantidad_producto, double precio_venta) {
}
