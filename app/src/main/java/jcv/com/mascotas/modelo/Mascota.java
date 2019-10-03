package jcv.com.mascotas.modelo;

import java.util.List;

public class Mascota {
    int id;
    String nombre;
    String sexo;
    String observaciones;
    int raza;
    List<FotoMascota>fotos_mascota;
    List<Usuario> usuario;
    List<caracteristicaMascota>caracteristicaMascotas;

    public Mascota() {
    }

    public Mascota(int id, String nombre, String sexo, String observaciones, int raza, List<FotoMascota> fotos_mascota, List<Usuario> usuario, List<caracteristicaMascota> caracteristicaMascotas) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.observaciones = observaciones;
        this.raza = raza;
        this.fotos_mascota = fotos_mascota;
        this.usuario = usuario;
        this.caracteristicaMascotas = caracteristicaMascotas;
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
        return fotos_mascota;
    }

    public void setFotomascota(List<FotoMascota> fotomascota) {
        this.fotos_mascota = fotomascota;
    }

    public List<FotoMascota> getFotos_mascota() {
        return fotos_mascota;
    }

    public void setFotos_mascota(List<FotoMascota> fotos_mascota) {
        this.fotos_mascota = fotos_mascota;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public List<caracteristicaMascota> getCaracteristicaMascotas() {
        return caracteristicaMascotas;
    }

    public void setCaracteristicaMascotas(List<caracteristicaMascota> caracteristicaMascotas) {
        this.caracteristicaMascotas = caracteristicaMascotas;
    }
}
