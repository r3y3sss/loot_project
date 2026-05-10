package com.example.loot_proyect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")

public class ProductoEntity {
    private int id_producto;
    private String descripcion;
    private float precio;
    private String img;

    public ProductoEntity(){}

    public ProductoEntity(String descripcion, float precio, String img){
        this.descripcion = descripcion;
        this.precio = precio;
        this.img = img;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId_producto(){return id_producto;}
    public void setId_producto(int id_producto){this.id_producto = id_producto;}

    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public float getPrecio(){return precio;}
    public void setPrecio(float precio){this.precio = precio;}

    public String getImg(){return img;}
    public void setImg(){this.img = img;}

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;
}
