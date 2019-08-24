package jcv.com.mascotas.modelo;

public class caracteristicaMascota {
    int id;
    String valor;
    int tipo_caracteristica;
    int mascota;

    public caracteristicaMascota(int id, String valor, int tipo_caracteristica, int mascota) {
        this.id = id;
        this.valor = valor;
        this.tipo_caracteristica = tipo_caracteristica;
        this.mascota = mascota;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getTipo_caracteristica() {
        return tipo_caracteristica;
    }

    public void setTipo_caracteristica(int tipo_caracteristica) {
        this.tipo_caracteristica = tipo_caracteristica;
    }

    public int getMascota() {
        return mascota;
    }

    public void setMascota(int mascota) {
        this.mascota = mascota;
    }
}
