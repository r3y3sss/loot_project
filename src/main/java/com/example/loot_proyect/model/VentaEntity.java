package com.example.loot_proyect.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ventas")

public class VentaEntity {
    private int id_venta;
    private LocalDate fecha_venta;
    private int cantidad_producto;
    private double precio_venta;

    public VentaEntity(){}

    public VentaEntity(LocalDate fecha_venta, int cantidad_producto, double precio_venta){
        this.fecha_venta = fecha_venta;
        this.cantidad_producto = cantidad_producto;
        this.precio_venta = precio_venta;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_venta(){return id_venta;}
    public void setId_venta(int id_venta){this.id_venta = id_venta;}

    public LocalDate getFecha_venta(){return fecha_venta;}
    public void setFecha_venta(LocalDate fecha_venta) {this.fecha_venta = fecha_venta;}

    public int getCantidad_producto(){return cantidad_producto;}
    public void setCantidad_producto(int cantidad_producto) {this.cantidad_producto = cantidad_producto;}

    public double getPrecio_venta(){return precio_venta;}
    public void setPrecio_venta(double precio_venta){this.precio_venta = precio_venta;}

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity  usuario;
}
