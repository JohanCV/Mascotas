package jcv.com.mascotas.servicios;

import java.util.List;

import jcv.com.mascotas.modelo.Publicacion;
import jcv.com.mascotas.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServicioPublicacion {
    public static String ip = "172.16.5.128:8000";

    @GET("/appatas/publicacion_list/")
    Call<List<Publicacion>> listarPublicacion();

}
    