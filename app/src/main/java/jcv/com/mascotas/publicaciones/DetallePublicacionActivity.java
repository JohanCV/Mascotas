package jcv.com.mascotas.publicaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import jcv.com.mascotas.R;
import jcv.com.mascotas.mascota.DetalleMascotaActivity;
import jcv.com.mascotas.mascota.MascotaEditarActivity;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.modelo.Publicacion;
import jcv.com.mascotas.modelo.PublicacionDetalle;
import jcv.com.mascotas.servicios.ServicioMascota;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static jcv.com.mascotas.servicios.ServicioPublicacion.url;

public class DetallePublicacionActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = DetallePublicacionActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;
    private ImageView regresar;
    private TextView nombreCabecera;

    private TextView nom_mascota;
    private TextView raza_mascota;
    private TextView edad_mascota;
    private TextView peso_mascota;
    private TextView tamanio_mascota;
    private TextView acce_mascota;
    private TextView enfer_mascota;
    private TextView nom_usuario;
    private TextView sexo_usuario;


    private androidx.appcompat.widget.Toolbar toolbarPerfilMascota;

    List<Publicacion> publicaciones = new ArrayList<>();
    int codigo_mascota = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_publicacion);

        findElemente();
        eventos();
        Intent i = getIntent();
        codigo_mascota = i.getIntExtra("id_mascota", 0);

        Toast.makeText(getApplicationContext(), codigo_mascota + "", Toast.LENGTH_LONG).show();
        detalle_publicacion();
    }

    private void findElemente() {
        regresar = (ImageView) findViewById(R.id.regresarPerfilEditar);
        nombreCabecera = (TextView) findViewById(R.id.perfilUsuarioNombreEditar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        toolbarPerfilMascota = findViewById(R.id.toolbarperfilEditar);
        nom_mascota = (TextView) findViewById(R.id.lbl_nombre_mascota);
        raza_mascota = (TextView) findViewById(R.id.lbl_raza_mascota);
        edad_mascota = (TextView) findViewById(R.id.lbl_edad_mascota);
        peso_mascota = (TextView) findViewById(R.id.lbl_peso_mascota);
        tamanio_mascota = (TextView) findViewById(R.id.lbl_tamanio_mascota);
        acce_mascota = (TextView) findViewById(R.id.lbl_accesorios_mascota);
        enfer_mascota = (TextView) findViewById(R.id.lbl_enfermedad_mascota);
        nom_usuario = (TextView) findViewById(R.id.lbl_nombre_usuario);
        sexo_usuario = (TextView) findViewById(R.id.lbl_sexo_usuario);
    }


    private void eventos() {
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(regresarHome);
            }
        });
        nombreCabecera.setText("Detalle Publicación");



    }

    private void detalle_publicacion() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        ServicioPublicacion serviciopublicacion = retrofit.create(ServicioPublicacion.class);
        Call<PublicacionDetalle> publicacion_detalle = serviciopublicacion.listar_publicacion_id(codigo_mascota);
        publicacion_detalle.enqueue(new Callback<PublicacionDetalle>() {
            @Override
            public void onResponse(Call<PublicacionDetalle> call, Response<PublicacionDetalle> response) {
                switch (response.code()) {
                    case 201:
                        PublicacionDetalle p = response.body();
                        nom_mascota.setText(p.getMascota().getNombre());
                        raza_mascota.setText(p.getMascota().getRaza());

                        break;
                    default:
                        Log.e("mascota1", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<PublicacionDetalle> call, Throwable t) {
                Log.e("mascota1", "" + t.getMessage());

            }
        });
    }


}
