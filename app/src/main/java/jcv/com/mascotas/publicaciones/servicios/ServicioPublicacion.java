package jcv.com.mascotas.publicaciones.servicios;

import java.util.List;

import jcv.com.mascotas.publicaciones.modelo.Publicacion;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioPublicacion {
    @GET("/appatas/publicacion_list/")
    Call<List<Publicacion>> listarPublicacion();
}
    