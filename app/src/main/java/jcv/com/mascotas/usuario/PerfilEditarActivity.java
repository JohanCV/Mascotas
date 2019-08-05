package jcv.com.mascotas.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import jcv.com.mascotas.R;

public class PerfilEditarActivity extends AppCompatActivity {

    private ImageView regresar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_editar);

        findElemente();
        event();
    }

    private void findElemente() {
        regresar = findViewById(R.id.regresarPerfilEditar);
    }

    private void event() {
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarPerfil = new Intent(getApplicationContext(), PerfilActivity.class);
                startActivity(regresarPerfil);
            }
        });
    }
}
