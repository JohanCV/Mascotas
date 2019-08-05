package jcv.com.mascotas.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import jcv.com.mascotas.R;
import jcv.com.mascotas.login.LoginActivity;

public class CrearPerfilActivity extends AppCompatActivity {
    private ImageView regresar;
    private TextView nombreCabecera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_crear);

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
                Intent regresarPerfil = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(regresarPerfil);
            }
        });

        nombreCabecera.setText("Crear Usuario");
    }
}
