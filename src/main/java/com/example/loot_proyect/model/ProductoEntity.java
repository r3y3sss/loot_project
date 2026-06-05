package com.example.loot_proyect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")

public class ProductoEntity {
    private int id_producto;
    private String nombre;
    private String descripcion;
    private float precio;
    private String img;

    public ProductoEntity(){}

    public ProductoEntity(String nombre,String descripcion, float precio, String img){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.img = img;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId_producto(){return id_producto;}
    public void setId_producto(int id_producto){this.id_producto = id_producto;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDescripcion(){return descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public float getPrecio(){return precio;}
    public void setPrecio(float precio){this.precio = precio;}

    public String getImg(){return img;}
    public void setImg(String img){this.img = img;}

    private UsuarioEntity usuario;
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    public UsuarioEntity getUsuario(){return usuario;}
    public void setUsuario(UsuarioEntity usuario) {this.usuario = usuario;}

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    public CategoriaEntity getCategoria(){return categoria;}
    public void setCategoria(CategoriaEntity categoria) {this.categoria = categoria;}
}
