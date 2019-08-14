package jcv.com.mascotas.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import jcv.com.mascotas.R;
import jcv.com.mascotas.modelo.Usuario;
import jcv.com.mascotas.publicaciones.HomeActivity;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import jcv.com.mascotas.servicios.ServicioUsuario;
import jcv.com.mascotas.usuario.CrearPerfilActivity;
import jcv.com.mascotas.usuario.PerfilActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private TextView crearCuenta;
    TextInputEditText usuario;
    TextInputEditText password;

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
        usuario = findViewById(R.id.edtxtUser);
        password = findViewById(R.id.edtxtPass);
    }

    private void event() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ServicioPublicacion.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServicioUsuario servicioUsuario = retrofit.create(ServicioUsuario.class);
                Call<Usuario> usr  = servicioUsuario.Login(usuario.getText().toString(), password.getText().toString());
                usr.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.code() == 200){
                            Usuario u = response.body();
                            Toast.makeText(getApplicationContext(), u.token, Toast.LENGTH_SHORT).show();
                            Intent iniciarsession = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(iniciarsession);
                            SharedPreferences prefs =
                                    getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putInt("id", u.id );
                            editor.putString("token", u.token.toString() );
                            editor.putString("email_usuario", "modificado@email.com");
                            editor.commit();
                        }else{
                            Toast.makeText(getApplicationContext(), "error" , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {

                    }
                });




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
