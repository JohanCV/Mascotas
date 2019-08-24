package jcv.com.mascotas.servicios;

import java.util.List;

import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.modelo.caracteristicaMascota;
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
    @FormUrlEncoded
    @POST("/appatas/caracteristica/")
    Call<caracteristicaMascota> registrarCaracteristicasMascotas(@Field("valor")String valor,
                                                                 @Field("tipo_caracteristica")int tipo_caracteristica,
                                                                 @Field("mascota") int mascota);

    @FormUrlEncoded
    @GET("/appatas/mascota/{id}/")
    Call<Mascota> detalleMascota (@Path("id") int id);


    @GET("/appatas/mascotas/{usuario}/")
    Call<List<Mascota>> mascotasPorUsuario(@Path("usuario") int usuario);


}

