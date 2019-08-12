package jcv.com.mascotas.publicaciones;

import androidx.appcompat.app.AppCompatActivity;
import jcv.com.mascotas.R;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.modelo.Publicacion;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import static jcv.com.mascotas.servicios.ServicioPublicacion.url;

public class CrearPublicacionActivity extends AppCompatActivity {
    private CheckBox chk_recompensa;
    private EditText txt_recompensa;
    private EditText txt_Fecha_perdida;
    private static final String CERO = "0";
    private static final String BARRA = "-";
    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);
    private ImageButton ib_ObtenerFecha;
    private Button btn_publicar;
    private Spinner spinner;
    private ImageView mapa;
    private int posicion;
    List<Mascota> mascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_publicacion);
        findElemente();
        eventos();

    }

    private void findElemente() {
        ib_ObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
        chk_recompensa = (CheckBox) findViewById(R.id.chk_recompensa);
        txt_recompensa = (EditText) findViewById(R.id.txt_recompensa);
        txt_recompensa.setEnabled(false);
        txt_Fecha_perdida = (EditText) findViewById(R.id.txt_fecha_perdida);
        btn_publicar = (Button) findViewById(R.id.btn_publicar);
        spinner =(Spinner) findViewById(R.id.spinner_escoger_mascota);
        mapa=(ImageView) findViewById(R.id.image_mapa);

    }

    private void eventos() {
        Listar_mascota_usuario();
        habilitar_recompensa();
        ib_ObtenerFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha();
            }
        });

        btn_publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Crear_publicacion();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                posicion = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No seleccionaron nada
            }
        });
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentmapa = new Intent(getApplicationContext(), MapaActivity.class);
                startActivity(intentmapa);
            }
        });
    }


    private void Crear_publicacion() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioPublicacion serviciopublicacion = retrofit.create(ServicioPublicacion.class);

        Call<Publicacion> registrar_publicacion = serviciopublicacion.registrar_publicacion(
                Double.parseDouble(txt_recompensa.getText().toString()),
                txt_Fecha_perdida.getText().toString(),
                mascotas.get(posicion).getId(),
                1.0,
                1.0);
        registrar_publicacion.enqueue(new Callback<Publicacion>() {
            @Override
            public void onResponse(Call<Publicacion> call, Response<Publicacion> response) {
                switch (response.code()) {
                    case 200:
                        Publicacion p = response.body();
                        Log.e("publicar", "" + p.getRecompensa());
                        break;
                    default:
                        Log.e("errorp", "" + response.code());
                }
            }

            @Override
            public void onFailure(Call<Publicacion> call, Throwable t) {
                Log.e("Error publicacion", t.getMessage());
            }
        });
    }


    private void obtenerFecha() {

        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int dayOfMonth, int month, int year) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10) ? CERO + String.valueOf(dayOfMonth) : String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10) ? CERO + String.valueOf(mesActual) : String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                txt_Fecha_perdida.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        }, dia, mes, anio);
        //Muestro el widget
        recogerFecha.show();

    }

    private void Listar_mascota_usuario() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioPublicacion Ssrviciopublicacion = retrofit.create(ServicioPublicacion.class);
        Call<List<Mascota>> call = Ssrviciopublicacion.listar_mascocas_usuario(4);
        call.enqueue(new Callback<List<Mascota>>() {
            @Override
            public void onResponse(Call<List<Mascota>> call, Response<List<Mascota>> response) {
                Log.e("Codigo ", response.code() + "");
                switch (response.code()) {
                    case 200:
                        Log.e("msj", response.body().toString());
                        mascotas = response.body();
                        List<String> perros = new LinkedList<>();
                        for (Mascota p : mascotas) {
                            Log.e("app", p.getNombre() + "");
                            perros.add(p.getNombre());
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_spinner_escoger_mascota, perros);
                        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<Mascota>> call, Throwable t) {
                Log.e("Error Appatas", t.getMessage());
            }
        });
    }

    public void habilitar_recompensa() {

        chk_recompensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    txt_recompensa.setEnabled(true);
                    txt_recompensa.findFocus();
                } else {
                    txt_recompensa.setEnabled(false);
                    txt_recompensa.setText("");
                }
            }
        });

    }

}
