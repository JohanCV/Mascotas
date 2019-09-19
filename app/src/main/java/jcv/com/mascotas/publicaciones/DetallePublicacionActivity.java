package jcv.com.mascotas.publicaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import jcv.com.mascotas.R;
import jcv.com.mascotas.mascota.DetalleMascotaActivity;
import jcv.com.mascotas.mascota.MascotaEditarActivity;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

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

public class DetallePublicacionActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = DetallePublicacionActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;
    private ImageView regresar;
    private TextView nombreCabecera;

    private androidx.appcompat.widget.Toolbar toolbarPerfilMascota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_publicacion);
        findElemente();
        //setUpBottomNavigationview();
        //setUpToolBar();
        eventos();

    }
    private void findElemente() {
        regresar =(ImageView) findViewById(R.id.regresarPerfilEditar);
        nombreCabecera = (TextView) findViewById(R.id.perfilUsuarioNombreEditar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        toolbarPerfilMascota = findViewById(R.id.toolbarperfilEditar);
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

}
