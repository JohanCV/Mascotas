package jcv.com.mascotas.mascota;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.mascota.adaptador.MascotaAdaptador;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

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

        findElemente();
        setUpBottomNavigationview();
        events();
    }

    private void findElemente() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        floatingActionButtonMascota = findViewById(R.id.floatingActionButtonMascota);

        recyclerView = findViewById(R.id.rv_mis_mascotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        llenarListaBaseDatos();
        mascotaAdaptador = new MascotaAdaptador(getApplicationContext(),listMascotas);

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

        mascotaAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdetalles = new Intent(getApplicationContext(), DetalleMascotaActivity.class);
                startActivity(intentdetalles);
            }
        });

    }
    private void llenarListaBaseDatos(){
        listMascotas.add(new Mascota("firulais","doberman","cojea"));
        listMascotas.add(new Mascota("pelucas","siberiano","plateado"));
        listMascotas.add(new Mascota("mailo","pubg","bebe"));
    }
}
