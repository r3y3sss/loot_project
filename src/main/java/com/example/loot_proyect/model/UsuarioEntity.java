package com.example.loot_proyect.model;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    @Column(name = "apellido_p")
    private String apellido_p;

    @Column(name = "apellido_m")
    private String apellido_m;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "num_telefono")
    private String num_telefono;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "direcciones_id_direccion", referencedColumnName = "id_direccion")
    private DireccionEntity direccionEntity;

    @OneToMany(mappedBy = "usuario")
    private List<ResenaEntity> resenas;

    public UsuarioEntity() {}

    public UsuarioEntity(String correo, String nombre, LocalDate fecha_nacimiento,
                         String apellido_p, String apellido_m, String contrasena,
                         String num_telefono) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.contrasena = contrasena;  // ← también estaba mal, usaba variable sin asignar
        this.num_telefono = num_telefono;
    }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFecha_nacimiento() { return fecha_nacimiento; }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) { this.fecha_nacimiento = fecha_nacimiento; }

    public String getApellido_p() { return apellido_p; }
    public void setApellido_p(String apellido_p) { this.apellido_p = apellido_p; }

    public String getApellido_m() { return apellido_m; }
    public void setApellido_m(String apellido_m) { this.apellido_m = apellido_m; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getNumTelefono() { return num_telefono; }
    public void setNumTelefono(String numTelefono) { this.num_telefono = numTelefono; }

    public DireccionEntity getDireccionEntity() { return direccionEntity; }
    public void setDireccionEntity(DireccionEntity direccionEntity) { this.direccionEntity = direccionEntity; }

    public List<ResenaEntity> getResenas() { return resenas; }
    public void setResenas(List<ResenaEntity> resenas) { this.resenas = resenas; }
}