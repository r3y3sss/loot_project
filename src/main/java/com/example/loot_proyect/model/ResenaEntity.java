package com.example.loot_proyect.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name = "reseñas")
public class ResenaEntity {
    private int Id_resenas;
    private String usuario_resena;

    public ResenaEntity(){}

    public  ResenaEntity(String resenas_usuario){
        this.usuario_resena = resenas_usuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId_resenas(){return Id_resenas;}
    public void setId_resenas(int id_resenas) {Id_resenas = id_resenas;}

    public String getUsuario_resena() {return usuario_resena;}
    public void setUsuario_resena(String usuario_resena) {this.usuario_resena = usuario_resena;}

    private UsuarioEntity usuario;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    public UsuarioEntity getUsuario(){return usuario;}
    public void setUsuario(UsuarioEntity usuario) {this.usuario = usuario;}
}
