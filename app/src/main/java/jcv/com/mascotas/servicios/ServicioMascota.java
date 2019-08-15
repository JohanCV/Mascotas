package jcv.com.mascotas.servicios;

import jcv.com.mascotas.modelo.Mascota;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ServicioMascota {
    String url = "http://proyectosmovil.pythonanywhere.com/";

    @FormUrlEncoded
    @POST("/appatas/mascota/")
    Call<Mascota> registrarMascota (@Field("nombre")String nombre,
                                    @Field("observaciones")String observaciones,
                                    @Field("sexo")String sexo,
                                    @Field("usuario")int usuario,
                                    @Field("raza") int raza);

    @Multipart
    @POST("/appatas/foto_mascota/")
    Call<ResponseBody> subirFotoMascota(@Part MultipartBody.Part image,  @Part("mascota") RequestBody mascota);

}

