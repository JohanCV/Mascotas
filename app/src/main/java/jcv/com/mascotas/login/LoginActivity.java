package jcv.com.mascotas.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

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
    private Button btnLogin;
    CallbackManager callbackManager;
    private View mProgressView;
    private View mLoginFormView;
    private ImageView mLogoView;
    private Usuario usuario;
    private TextView user, pass;
    public static String ip = "http://proyectosmovil.pythonanywhere.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        mProgressView = findViewById(R.id.login_progress);
        mLogoView = (ImageView) findViewById(R.id.image_logo);

        user = findViewById(R.id.edtxtUser);
        pass = findViewById(R.id.edtxtPass);

        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("iniciofb", "logeo");
                Toast.makeText(getApplicationContext()
                        ,loginResult.getAccessToken().toString()
                        , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {
                // App code
                Log.d("iniciofb", "cancel");
                Toast.makeText(getApplicationContext(),"Cancelado", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException exception) {
                Log.d("iniciofb", "Error");
                Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
            }
        });

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


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ip)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServicioUsuario servicioUsuario = retrofit.create(ServicioUsuario.class);

                Call<Usuario> usr  = servicioUsuario.Login(user.getText().toString(), pass.getText().toString());
                usr.enqueue(new Callback<Usuario>() {

                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.code() == 200){
                            Usuario usr = response.body();
                            Toast.makeText(getApplicationContext(), usr.token, Toast.LENGTH_SHORT).show();
                            //colocando intent que me lleve a la pantalla de inicio
                            Intent iniciarsession = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(iniciarsession);
                        }else{
                            Toast.makeText(getApplicationContext(), "Error de inicio mi pata" , Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString() , Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean isUserIdValid(String userId) {
        return userId.length() == 10;
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;
        mLogoView.setVisibility(visibility);
        mLoginFormView.setVisibility(visibility);
    }

    private void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

}
