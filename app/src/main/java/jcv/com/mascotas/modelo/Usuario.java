package jcv.com.mascotas.modelo;

public class Usuario {
    public String token;
    public String username;
    public String password;

    public Usuario() {
    }

    public Usuario(String token, String username, String password) {
        this.token = token;
        this.username = username;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}