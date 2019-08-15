package jcv.com.mascotas.servicios;

import java.util.List;

import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.modelo.Publicacion;
import jcv.com.mascotas.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServicioPublicacion {
    String url = "http://proyectosmovil.pythonanywhere.com";

    @GET("/appatas/publicacion_list/")
    Call<List<Publicacion>> listarPublicacion();


    @GET ("/appatas/mascotas/{usuario}/")
    Call<List<Mascota>>listar_mascocas_usuario(@Path("usuario") int usuario);


    @POST("/appatas/publicacion/")
    @FormUrlEncoded
    Call<Publicacion>registrar_publicacion(@Field("recompensa")Double recompensa,
                                           @Field("fecha_perdida")String fecha_perdida,
                                           @Field("mascota")int mascota,
                                           @Field("latitud_perdida")Double latitud_perdida,
                                           @Field("longitud_perdida")Double longitud_perdida);

    @PUT("/appatas/publicacion/{pk}/")
    @FormUrlEncoded
    Call<Publicacion>actualizar_publicacion(@Path("pk")int pk,
                                            @Field("recompensa")Double recompensa,
                                            @Field("fecha_perdida")String fecha_perdida,
                                            @Field("mascota")int mascota,
                                            @Field("latitud_perdida")Double latitud_perdida,
                                            @Field("longitud_perdida")Double longitud_perdida);

}
    