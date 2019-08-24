package jcv.com.mascotas.modelo;

import java.util.List;

public class Mascota {
    int id;
    String nombre;
    String sexo;
    String observaciones;
    int raza;
    List<FotoMascota>fotomascota;

    public Mascota(int id, String nombre, String sexo, String observaciones, int raza, List<FotoMascota> fotomascota) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.observaciones = observaciones;
        this.raza = raza;
        this.fotomascota = fotomascota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }

    public List<FotoMascota> getFotomascota() {
        return fotomascota;
    }

    public void setFotomascota(List<FotoMascota> fotomascota) {
        this.fotomascota = fotomascota;
    }
}
