package jcv.com.mascotas.mascota;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import jcv.com.mascotas.R;
import jcv.com.mascotas.login.LoginActivity;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.servicios.ServicioMascota;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearPerfilMascotaActivity extends AppCompatActivity {
    private ImageView regresar;
    private TextView nombreCabecera;
    private

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_perfil_crear);

        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(ServicioMascota.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioMascota servicioMascota = retrofit.create(ServicioMascota.class);

        Call<Mascota> registrarMascota = servicioMascota.registrarMascota("dumbo","rabioso","M",4,1);
        registrarMascota.enqueue(new Callback<Mascota>() {
            @Override
            public void onResponse(Call<Mascota> call, Response<Mascota> response) {
                switch (response.code()){
                    case 200:
                        Mascota m=response.body();
                        Log.e("mascota",""+m.getNombre());
                        break;
                    default:
                        Log.e("mascota", response.code()+"");

                }
            }

            @Override
            public void onFailure(Call<Mascota> call, Throwable t) {
                Log.e("mascota",""+t.getMessage());

            }
        });



        findElemente();
        event();




    }

    private void findElemente() {
        regresar = findViewById(R.id.regresarPerfilEditar);
        nombreCabecera = findViewById(R.id.perfilUsuarioNombreEditar);

    }

    private void event() {
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarPerfil = new Intent(getApplicationContext(), MascotaActivity.class);
                startActivity(regresarPerfil);
            }
        });

        nombreCabecera.setText("Crear Mi Mascota");
    }
}
