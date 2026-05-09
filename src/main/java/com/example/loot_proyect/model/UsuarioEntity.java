package com.example.loot_proyect.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "usuarios" )
public class UsuarioEntity {
    private int id_usuario;
    private String correo;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String apellidoP;
    private String apellidoM;
    private String contrasena;
    private String numTelefono;
    private DireccionEntity direccionEntity;



    public UsuarioEntity(){
    }

    public UsuarioEntity(String correo, String nombre , LocalDate fechaNacimiento, String apellidoP, String apellidoM, String contraseña, String numTelefono){
        this.correo = correo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.contrasena = contrasena;
        this.numTelefono = numTelefono;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId(){return id_usuario;}
    private void setId(int id_usuario){this.id_usuario = id_usuario;}

    public String getCorreo(){return correo;}
    public void setCorreo(String correo){this.correo = correo;}

    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public String getApellidoP() {return apellidoP;}
    public void setApellidoP(String ApellidoP){this.apellidoP = apellidoP;}

    public String getApellidoM() {return apellidoM;}
    public void setApellidoM(String apellidoM) {this.apellidoM = apellidoM;}

    public String getContraseña() {return contrasena;}
    public void setContraseña(String contraseña) {this.contrasena = contraseña;}

    public String getNumTelefono() {return numTelefono;}
    public void setNumTelefono(String numTelefono) {this.numTelefono = numTelefono;}

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "direcciones_id_direccion", referencedColumnName = "id_direccion")
    public DireccionEntity getDireccionEntity() {
        return direccionEntity;
    }

    public void setDireccionEntity(DireccionEntity direccionEntity) {
        this.direccionEntity = direccionEntity;
    }
    @OneToMany(mappedBy = "usuario")
    private List<ResenasEntity> resenas;
}
