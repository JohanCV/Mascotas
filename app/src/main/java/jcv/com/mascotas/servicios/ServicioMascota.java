package jcv.com.mascotas.servicios;

import jcv.com.mascotas.modelo.Mascota;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface ServicioMascota {
    String url = "http://proyectosmovil.pythonanywhere.com";

    @FormUrlEncoded
    @POST("/appatas/mascota/")
    Call<Mascota> registrarMascota (@Field("nombre")String nombre,
                                    @Field("observaciones")String observaciones,
                                    @Field("sexo")String sexo,
                                    @Field("usuario")int usuario,
                                    @Field("raza") int raza);

}

