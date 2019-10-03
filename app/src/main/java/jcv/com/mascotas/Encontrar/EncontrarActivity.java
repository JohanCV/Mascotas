package jcv.com.mascotas.Encontrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

public class EncontrarActivity extends AppCompatActivity {
    private static final String TAG = "EncontrarActivity";
    private static final int ACTIVITY_NUM = 1;
    private Context mcontext = EncontrarActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;

    private ImageView regresar;
    private TextView nombreCabecera;
    private Button btnSave;
    private EditText nombre;
    private EditText apellido;
    RadioButton rb;
    private EditText Email;
    private EditText Telefono;
    Spinner departamento;
    Spinner provincia;
    Spinner distrito;
    private EditText Contrasena;
    private EditText RepeteContrasena;
    String sexo = "M";
    List<String[]> ubigeo;
    List<List<String[]>> ubigeoDistrito;
    int provinciaSeleccionada = 0;
    private ImageButton SubirFoto;
    private ImageView Fotoperfil;
    private static final int TAKE_PICTURE = 1;
    private static final int CAMERA_REQUEST1 = 1887;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int ACTIVITY_SELECT_IMAGE = 1020,
            ACTIVITY_SELECT_FROM_CAMERA = 1040, ACTIVITY_SHARE = 1030;


    String[] datosdesexo = { "Hembra", "Macho", "Otro"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encontrar);

        Log.d(TAG, " On create: Starting");

        findElemente();
        setUpBottomNavigationview();
        events();
    }

    private void findElemente() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
    }

    private void setUpBottomNavigationview() {
        //bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationView);
        bottomNavigationViewHelper.enableBottomNavigationView(bottomNavigationView, mcontext);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    private void events() {

    }
}
