package jcv.com.mascotas.modelo;

import java.util.Date;

public class Publicacion {

    //servicio atributos
    int idpublicacion;
    Date fecha_publicacion;
    Double recompensa;
    Date fecha_perdida;
    Double latitud_perdida;
    Double longitud_perdida;
    String estado;
    int mascota;


    public Publicacion(int idpublicacion, Date fecha_publicacion, Double recompensa, Date fecha_perdida, Double latitud_perdida, Double longitud_perdida, String estado, int mascota) {
        this.idpublicacion = idpublicacion;
        this.fecha_publicacion = fecha_publicacion;
        this.recompensa = recompensa;
        this.fecha_perdida = fecha_perdida;
        this.latitud_perdida = latitud_perdida;
        this.longitud_perdida = longitud_perdida;
        this.estado = estado;
        this.mascota = mascota;
    }

    public int getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(int idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public Double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Double recompensa) {
        this.recompensa = recompensa;
    }

    public Date getFecha_perdida() {
        return fecha_perdida;
    }

    public void setFecha_perdida(Date fecha_perdida) {
        this.fecha_perdida = fecha_perdida;
    }

    public Double getLatitud_perdida() {
        return latitud_perdida;
    }

    public void setLatitud_perdida(Double latitud_perdida) {
        this.latitud_perdida = latitud_perdida;
    }

    public Double getLongitud_perdida() {
        return longitud_perdida;
    }

    public void setLongitud_perdida(Double longitud_perdida) {
        this.longitud_perdida = longitud_perdida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getint() {
        return mascota;
    }

    public void setint(int mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "idpublicacion=" + idpublicacion +
                ", fecha_publicacion=" + fecha_publicacion +
                ", recompensa=" + recompensa +
                ", fecha_perdida=" + fecha_perdida +
                ", latitud_perdida=" + latitud_perdida +
                ", longitud_perdida=" + longitud_perdida +
                ", estado='" + estado + '\'' +
                ", mascota=" + mascota +
                '}';
    }
}
