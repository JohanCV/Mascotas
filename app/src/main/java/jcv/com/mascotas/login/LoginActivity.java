package jcv.com.mascotas.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jcv.com.mascotas.R;
import jcv.com.mascotas.publicaciones.HomeActivity;
import jcv.com.mascotas.usuario.CrearPerfilActivity;
import jcv.com.mascotas.usuario.PerfilActivity;

public class LoginActivity extends AppCompatActivity {

    private TextView crearCuenta;

    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findElemente();
        event();
    }

    private void findElemente() {
        btnLogin = findViewById(R.id.btnLogin);
        crearCuenta = findViewById(R.id.textViewCrearCuenta);
    }

    private void event() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciarsession = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(iniciarsession);
            }
        });

        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent crearcuenta = new Intent(getApplicationContext(), CrearPerfilActivity.class);
                startActivity(crearcuenta);
            }
        });
    }
}
