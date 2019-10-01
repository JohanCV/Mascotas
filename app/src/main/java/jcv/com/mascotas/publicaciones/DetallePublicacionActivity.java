package jcv.com.mascotas.publicaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import jcv.com.mascotas.R;
import jcv.com.mascotas.mascota.DetalleMascotaActivity;
import jcv.com.mascotas.mascota.MascotaEditarActivity;
import jcv.com.mascotas.modelo.Publicacion;
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

import java.util.ArrayList;
import java.util.List;

public class DetallePublicacionActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = DetallePublicacionActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;
    private ImageView regresar;
    private TextView nombreCabecera;

    private androidx.appcompat.widget.Toolbar toolbarPerfilMascota;

    List<Publicacion> publicaciones = new ArrayList<>();
    private int pos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_publicacion);
        findElemente();
        eventos();

    }
    private void findElemente() {
        regresar =(ImageView) findViewById(R.id.regresarPerfilEditar);
        nombreCabecera = (TextView) findViewById(R.id.perfilUsuarioNombreEditar);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        toolbarPerfilMascota = findViewById(R.id.toolbarperfilEditar);
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
