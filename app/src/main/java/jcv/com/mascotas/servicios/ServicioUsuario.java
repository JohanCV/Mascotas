package jcv.com.mascotas.servicios;

import jcv.com.mascotas.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServicioUsuario {

    @FormUrlEncoded
    @POST("/appatas/login/")
    Call<Usuario> Login(@Field("username") String usuario, @Field("password") String password);
}
