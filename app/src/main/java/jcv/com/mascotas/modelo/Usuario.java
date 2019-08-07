package jcv.com.mascotas.modelo;

public class Usuario {
    public String token;

    public Usuario() {
    }

    public Usuario(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
