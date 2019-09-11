package jcv.com.mascotas.mascota;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import jcv.com.mascotas.R;
import jcv.com.mascotas.login.LoginActivity;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.modelo.caracteristicaMascota;
import jcv.com.mascotas.servicios.ServicioMascota;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearPerfilMascotaActivity extends AppCompatActivity {
    private ImageView regresar;
    private TextView nombreCabecera;
    private EditText txt_nombremascota;
    private EditText txt_razamascota;
    private Spinner spinner_edad;
    private Spinner spinner_peso;
    private Spinner spinner_tamano;
    private Spinner spinner_color;
    private Spinner spinner_sexo;
    private EditText txt_accesoriosmascota;
    private EditText txt_enfermedadesmascota;
    private ImageView iv_foto1;
    private ImageView iv_foto2;
    private Button btn_guardarmascota;

    String sexo = "M";
    String edad = "cachorro";
    String color = "cafe";
    String tamano = "pequeño";
    String peso = "1 kg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_perfil_crear);




        findElemente();
        event();


    }

    private void findElemente() {
        regresar = findViewById(R.id.regresarPerfilEditar);
        nombreCabecera = findViewById(R.id.perfilUsuarioNombreEditar);
        txt_nombremascota = findViewById(R.id.txt_nombremascota);
        txt_razamascota = findViewById(R.id.txt_razamascota);
        txt_accesoriosmascota = findViewById(R.id.txt_accesoriosmascota);

        spinner_edad = findViewById(R.id.spinner_edad);
        ArrayAdapter<CharSequence> adapter_edad = ArrayAdapter.createFromResource(this,
                R.array.edad_mascota, android.R.layout.simple_spinner_item);
        adapter_edad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_edad.setAdapter(adapter_edad);

        spinner_peso = findViewById(R.id.spinner_peso);
        ArrayAdapter<CharSequence> adapter_peso = ArrayAdapter.createFromResource(this,
                R.array.peso_mascota, android.R.layout.simple_spinner_item);
        adapter_peso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_peso.setAdapter(adapter_peso);

        spinner_tamano = findViewById(R.id.spinner_tamano);
        ArrayAdapter<CharSequence> adapter_tamano = ArrayAdapter.createFromResource(this,
                R.array.tamano_mascota, android.R.layout.simple_spinner_item);
        adapter_tamano.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tamano.setAdapter(adapter_tamano);

        spinner_color =findViewById(R.id.spinner_color);
        ArrayAdapter<CharSequence> adapter_color = ArrayAdapter.createFromResource(this,
                R.array.color_mascota, android.R.layout.simple_spinner_item);
        adapter_color.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_color.setAdapter(adapter_color);

        spinner_sexo =findViewById(R.id.spinner_sexo);
        ArrayAdapter<CharSequence> adapter_sexo = ArrayAdapter.createFromResource(this,
                R.array.sexo_mascota, android.R.layout.simple_spinner_item);
        adapter_sexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sexo.setAdapter(adapter_sexo);

        btn_guardarmascota = findViewById(R.id.btn_guardarmascota);
    }

    private void event() {
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regresarPerfil = new Intent(getApplicationContext(), MascotaActivity.class);
                startActivity(regresarPerfil);
            }
        });

        btn_guardarmascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Guardar_mascota();
            }
        });

        spinner_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1)
                {
                    color="negro";
                }
                else if (i==2)
                {
                    color="blanco";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner_tamano.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1)
                {
                    tamano="mediano";
                }
                else if (i==2)
                {
                    tamano="grande";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner_peso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1) {
                    peso="2 kg";
                }else if (i==2){
                    peso="3 kg";
                }else if (i==3){
                    peso="4 kg";
                }else if (i==4){
                    peso="5 kg";
                }else if (i==5){
                    peso="6 kg";
                }else if (i==6){
                    peso="7 kg";
                }else if (i==7){
                    peso="8 kg";
                }else if (i==8){
                    peso="9 kg";
                }else if (i==9){
                    peso="10 kg";
                }else if (i==10){
                    peso="11 kg";
                }else if (i==11){
                    peso="12 kg";
                }else if (i==12){
                    peso="13 kg";
                }else if (i==13){
                    peso="14 kg";
                }else if (i==14){
                    peso="15 kg";
                }else if (i==15){
                    peso="16 kg";
                }else if (i==16){
                    peso="17 kg";
                }else if (i==17){
                    peso="18 kg";
                }else if (i==18){
                    peso="19 kg";
                }else if (i==19){
                    peso="20 kg";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_edad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1){
                    edad="joven";
                }else if (i==2){
                    edad="adulto";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    sexo="H";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nombreCabecera.setText("Crear Mi Mascota");
    }




    private void Guardar_mascota(){
        Retrofit retrofit  = new Retrofit.Builder()
                .baseUrl(ServicioMascota.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioMascota servicioMascota = retrofit.create(ServicioMascota.class);

        Call<Mascota> registrarMascota = servicioMascota.registrarMascota(txt_nombremascota.getText().toString(),txt_accesoriosmascota.getText().toString(),sexo,4,1);
        registrarMascota.enqueue(new Callback<Mascota>() {
            @Override
            public void onResponse(Call<Mascota> call, Response<Mascota> response) {
                switch (response.code()){

                    case 201:
                        Mascota m=response.body();
                        Log.e("mascota",""+m.getNombre());
                        Guardar_Caracteristica(edad, 1, m.getId());
                        Log.e("mascota1",""+m.getNombre());
                        Guardar_Caracteristica(color, 3, m.getId());
                        Log.e("mascota1",""+m.getNombre());
                        break;
                    default:
                        Log.e("mascota", response.code()+"");
                        Log.e("mascota1", response.code()+"");

                }
            }

            @Override
            public void onFailure(Call<Mascota> call, Throwable t) {
                Log.e("mascota",""+t.getMessage());
                Log.e("mascota1",""+t.getMessage());

            }
        });



        findElemente();
        event();




    }


        private void Guardar_Caracteristica( String valor, int tipo_caracteristica, int mascota){
            Retrofit retrofit  = new Retrofit.Builder()
                    .baseUrl(ServicioMascota.url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ServicioMascota servicioMascota = retrofit.create(ServicioMascota.class);
            Call<caracteristicaMascota> registrarCaracteristicasMascotas = servicioMascota.registrarCaracteristicasMascotas(valor,tipo_caracteristica,mascota);
        registrarCaracteristicasMascotas.enqueue(new Callback<caracteristicaMascota>(){

            @Override
            public void onResponse(Call<caracteristicaMascota> call, Response<caracteristicaMascota> response) {
                switch (response.code()){
                    case 201:
                        caracteristicaMascota m=response.body();
                        Log.e("mascota2",""+m.getValor());
                        break;
                    default:
                        Log.e("mascota2", response.code()+"");
                }
            }


         @Override
         public void onFailure(Call<caracteristicaMascota> call, Throwable t) {
                            Log.e("mascota2",""+t.getMessage());

                        }
                    });

                }
            }