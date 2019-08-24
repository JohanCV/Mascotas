package jcv.com.mascotas.mascota;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jcv.com.mascotas.R;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.servicios.ServicioMascota;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetalleMascotaActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = DetalleMascotaActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;
    private TextView cabeceranombre;
    private ImageView regresar;
    private TextView txt_nombre;
    private TextView txt_raza;
    private TextView txt_edad;
    private TextView txt_color;
    private TextView txt_peso;
    private TextView txt_tamaño;
    private TextView txt_accesorios;

    private androidx.appcompat.widget.Toolbar toolbarPerfilMascota;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_detalle);
        findElements();
        setUpBottomNavigationview();
        setUpToolBar();
        events();
    }

    private void findElements() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        toolbarPerfilMascota = findViewById(R.id.toolbarperfilEditar);
        cabeceranombre = findViewById(R.id.perfilUsuarioNombreEditar);
        regresar = findViewById(R.id.regresarPerfilEditar);
        txt_nombre=findViewById(R.id.txt_nombre);
        txt_raza=findViewById(R.id.txt_raza);
        txt_edad=findViewById(R.id.txt_edad);
        txt_color=findViewById(R.id.txt_color);
        txt_peso=findViewById(R.id.txt_peso);
        txt_tamaño=findViewById(R.id.txt_tamaño);
        txt_accesorios=findViewById(R.id.txt_accesorios);

    }

    private void setUpToolBar(){
        setSupportActionBar(toolbarPerfilMascota);
        toolbarPerfilMascota.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_perfil_mascota_edit:
                        Intent intentEditPerfilMascota = new Intent(getApplicationContext(), MascotaEditarActivity.class);
                        startActivity(intentEditPerfilMascota);
                        break;
                    case R.id.menu_perfil_mascota_eliminar:
                        Toast.makeText(mcontext, "Se elimina por id", Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });
    }


    private void setUpBottomNavigationview() {
        //bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationView);
        bottomNavigationViewHelper.enableBottomNavigationView(bottomNavigationView, mcontext);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil_mascota,menu);
        return true;
    }

    private void events() {
        cabeceranombre.setText("Mi Mascota");

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarDetalleMascota = new Intent(getApplicationContext(), MascotaActivity.class);
                startActivity(regresarDetalleMascota);
            }
        });
    }

    private void Detalle_mascota(){
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(ServicioMascota.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioMascota servicioMascota = retrofit.create(ServicioMascota.class);

        Call<Mascota> registrarMascota = servicioMascota.detalleMascota(7);

        registrarMascota.enqueue(new Callback<Mascota>() {
            @Override
            public void onResponse(Call<Mascota> call, Response<Mascota> response) {
                switch (response.code()){
                    case 201:
                        Mascota m=response.body();
                        txt_nombre.setText(m.getNombre());
                        break;
                    default:
                        Log.e("mascota1", response.code()+"");

                }
            }

            @Override
            public void onFailure(Call<Mascota> call, Throwable t) {
                Log.e("mascota1",""+t.getMessage());

            }
        });
    }
}
