package com.example.loot_proyect.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "direcciones" )

public class DireccionEntity {
    private int id_direccion;
    private String calle;
    private String colonia;
    private int cp;
    private String municipio;
    private String estado;

    public DireccionEntity(){}

    public DireccionEntity(String calle, String colonia, int cp, String municipio, String estado) {
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.municipio = municipio;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %s, %s",
                calle, colonia, cp, municipio, estado);
    }
}
