package jcv.com.mascotas.mascota;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import jcv.com.mascotas.R;
import jcv.com.mascotas.usuario.PerfilActivity;

public class MascotaEditarActivity extends AppCompatActivity {
    private ImageView regresar;
    private TextView cabeceranombre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_perfil_editar);
        findElemente();
        event();
    }

    private void findElemente() {
        regresar = findViewById(R.id.regresarPerfilEditar);
        cabeceranombre = findViewById(R.id.perfilUsuarioNombreEditar);
    }

    private void event() {
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarMascotaDetalle = new Intent(getApplicationContext(), DetalleMascotaActivity.class);
                startActivity(regresarMascotaDetalle);
            }
        });

        cabeceranombre.setText("Edicion de Mi Mascota");
    }
}
