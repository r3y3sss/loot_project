package com.example.loot_proyect.model;


import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class CategoriaEntity {
    private int id_categoria;
    private String nombre;

    public CategoriaEntity(){}

    public CategoriaEntity(String nombre){
        this.nombre = nombre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId_categoria(){return id_categoria;}
    public void setId_categoria(int id_categoria){this.id_categoria = id_categoria;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

}
