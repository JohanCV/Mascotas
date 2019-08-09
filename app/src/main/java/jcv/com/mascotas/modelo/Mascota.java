package jcv.com.mascotas.modelo;

public class Mascota {
    int id;
    String nombre;
    String raza;
    String observaciones;

    public Mascota(String nombre, String raza, String observaciones) {
        this.nombre = nombre;
        this.raza = raza;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
