package jcv.com.mascotas.servicios;

import jcv.com.mascotas.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServicioUsuario {
    public static String ip = "http://proyectosmovil.pythonanywhere.com";
    @POST("/appatas/login/")
    @FormUrlEncoded
    Call<Usuario> Login(@Field("username") String usuario, @Field("password") String password);

    @POST("/appatas/usuario/")
    @FormUrlEncoded
    Call<Usuario> CrearUsuario(@Field("username") String username,
                               @Field("first_name") String first_name,
                               @Field("last_name") String last_name,
                               @Field("email") String email,
                               @Field("password") String password,
                               @Field("sexo") String sexo ,
                               @Field("telefono") String telefono );
}
