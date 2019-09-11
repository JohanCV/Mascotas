package jcv.com.mascotas.mascota;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.mascota.adaptador.MascotaAdaptador;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static jcv.com.mascotas.servicios.ServicioPublicacion.url;

public class MascotaActivity extends AppCompatActivity {
    private static final String TAG = "MascotaActivity";
    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = MascotaActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;

    private RecyclerView recyclerView;
    private MascotaAdaptador mascotaAdaptador;
    private List<Mascota> listMascotas = new ArrayList<>();
    private FloatingActionButton floatingActionButtonMascota;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_perfil);
        Log.d(TAG, " On create: Starting");

        findElements();
        setUpBottomNavigationview();
        events();
    }

    private void findElements() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        floatingActionButtonMascota = findViewById(R.id.floatingActionButtonMascota);

        recyclerView = findViewById(R.id.rv_mis_mascotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        llenarListaBaseDatos();


        recyclerView.setAdapter(mascotaAdaptador);
    }

    private void setUpBottomNavigationview() {
        //bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationView);
        bottomNavigationViewHelper.enableBottomNavigationView(bottomNavigationView, mcontext);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void events() {
        floatingActionButtonMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcrearmascota = new Intent(getApplicationContext(), CrearPerfilMascotaActivity.class);
                startActivity(intentcrearmascota);
            }
        });



    }
    private void llenarListaBaseDatos(){
        //listMascotas.add(new Mascota(1,"firulais","M","cojea",1));
        //listMascotas.add(new Mascota(2,"pelucas","M","plateado",1));
        //listMascotas.add(new Mascota(3,"mailo","F","bebe",1));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioPublicacion servicioPublicacion = retrofit.create(ServicioPublicacion.class);
        Call<List<Mascota>> call = servicioPublicacion.listar_mascotas_usuario(4);
        call.enqueue(new Callback<List<Mascota>>() {
            @Override
            public void onResponse(Call<List<Mascota>> call, Response<List<Mascota>> response) {
                Log.e("Codigo ", response.code() + "");
                switch (response.code()) {
                    case 200:
                        Log.e("msj", response.body().toString());
                        listMascotas = response.body();
                        List<String> perros = new LinkedList<>();
                        for (Mascota p : listMascotas) {
                            Log.e("app", p.getNombre() + "");
                            perros.add(p.getNombre());
                        }

                        mascotaAdaptador = new MascotaAdaptador(getApplicationContext(),listMascotas);
                        mascotaAdaptador.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intentdetalles = new Intent(getApplicationContext(), DetalleMascotaActivity.class);
                                startActivity(intentdetalles);
                            }
                        });
                        recyclerView.setAdapter(mascotaAdaptador);
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Mascota>> call, Throwable t) {
                Log.e("Error Appatas", t.getMessage());
            }
        });

    }
}
