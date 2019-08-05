package jcv.com.mascotas.usuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import jcv.com.mascotas.R;
import jcv.com.mascotas.login.LoginActivity;
import jcv.com.mascotas.publicaciones.HomeActivity;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

public class PerfilActivity extends AppCompatActivity {

    private static final String TAG = "PerfilActivity";
    private static final int ACTIVITY_NUM = 4;
    private Context mcontext = PerfilActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;
    private androidx.appcompat.widget.Toolbar toolbarPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Log.d(TAG, " On create: Starting");

        findElemente();
        setUpBottomNavigationview();
        setUpToolBar();
        events();
    }

    private void findElemente() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        toolbarPerfil = findViewById(R.id.toolbarperfil);
    }

    private void setUpToolBar(){
        setSupportActionBar(toolbarPerfil);
        toolbarPerfil.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_perfil_edit:
                        Intent intentEditPerfil = new Intent(getApplicationContext(), PerfilEditarActivity.class);
                        startActivity(intentEditPerfil);
                        break;
                    case R.id.menu_perfil_eliminar:
                        break;
                    case R.id.menu_perfil_sali:
                        Intent intentCerrarSession = new Intent(getApplicationContext(), LoginActivity.class);
                        //hay q eliminar la session del usuario
                        startActivity(intentCerrarSession);
                        break;
                }
                return false;
            }
        });
    }


    private void setUpBottomNavigationview() {
        //bottomNavigationViewHelper.setUpBottomNavigationView(bottomNavigationView);
        bottomNavigationViewHelper.enableBottomNavigationView(bottomNavigationView, mcontext);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil_usuario,menu);
        return true;
    }

    private void events() {

    }


}
