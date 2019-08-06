package jcv.com.mascotas.mascota;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

public class DetalleMascotaActivity extends AppCompatActivity {

    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = DetalleMascotaActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;
    private TextView cabeceranombre;
    private ImageView regresar;

    private androidx.appcompat.widget.Toolbar toolbarPerfilMascota;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_detalle);
        findElemente();
        setUpBottomNavigationview();
        setUpToolBar();
        events();
    }

    private void findElemente() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        toolbarPerfilMascota = findViewById(R.id.toolbarperfilEditar);
        cabeceranombre = findViewById(R.id.perfilUsuarioNombreEditar);
        regresar = findViewById(R.id.regresarPerfilEditar);
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
}
