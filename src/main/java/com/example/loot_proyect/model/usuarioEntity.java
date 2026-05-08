package com.example.loot_proyect.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import javax.annotation.processing.Generated;

@Entity
@table = "usuarios"
public class usuarioEntity {
    private int id;
    private String correo;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String apellidoP;
    private String apellidoM;
    private String contraseña;
    private String numTelefono;


    public usuarioEntity (){
    }

    public usuarioEntity(String correo, String nombre , LocalDate fechaNacimiento, String apellidoP, String apellidoM, String contraseña, String numTelefono){
        this.correo = correo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.contraseña = contraseña;
        this.numTelefono = numTelefono;
    }

    @id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")

    public int getId(){return id;}
    private void setId(int id){this.id = id;}

    public String getCorreocorreo(){return correo;}
    public void setCorreo(){this.correo = correo;}

    public String getNombre(){return nombre;}
    public void setNombre(){this.nombre = nombre;}

    public LocalDate getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(LocalDate fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

    public String getApellidoM() {return apellidoM;}
    public void setApellidoP(){this.apellidoP = apellidoP;}

    public String getApellidoP() {return apellidoP;}
    public void setApellidoM(String apellidoM) {this.apellidoM = apellidoM;}

    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    public String getNumTelefono() {return numTelefono;}
    public void setNumTelefono(String numTelefono) {this.numTelefono = numTelefono;}

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
}
