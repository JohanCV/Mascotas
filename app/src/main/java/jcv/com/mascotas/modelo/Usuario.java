package jcv.com.mascotas.modelo;

public class Usuario {
    public String token;
    public int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Usuario(String token, int id, String username) {
        this.token = token;
        this.id = id;
        this.username = username;
    }

    public String username;

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
