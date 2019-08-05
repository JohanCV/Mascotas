package jcv.com.mascotas.modelo;

import java.util.Date;

public class Publicacion {

    //servicio atributos
    private Float recompensa;
    private Date fecha_perdida;
    private Float latitud_perdida;
    private Float longitud_perdida;



    Publicacion(){

    }
    //Get a Set Service's
    public Float getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Float recompensa) {
        this.recompensa = recompensa;
    }

    public Date getFecha_perdida() {
        return fecha_perdida;
    }

    public void setFecha_perdida(Date fecha_perdida) {
        this.fecha_perdida = fecha_perdida;
    }

    public Float getLatitud_perdida() {
        return latitud_perdida;
    }

    public void setLatitud_perdida(Float latitud_perdida) {
        this.latitud_perdida = latitud_perdida;
    }

    public Float getLongitud_perdida() {
        return longitud_perdida;
    }

    public void setLongitud_perdida(Float longitud_perdida) {
        this.longitud_perdida = longitud_perdida;
    }
}
