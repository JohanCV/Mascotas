package jcv.com.mascotas.modelo;

public class Usuario {
    public String token;
    public int id;
    public String username;
    public String password;

    public Usuario() {

    }
//    public Usuario(String username, String password) {
//        this.username = username;
//        this.password = password;
//
//    }

    public Usuario(String token, int id, String username, String password) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
