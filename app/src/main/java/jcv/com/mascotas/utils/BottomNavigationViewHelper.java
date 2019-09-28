package jcv.com.mascotas.utils;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jcv.com.mascotas.Encontrar.EncontrarActivity;
import jcv.com.mascotas.publicaciones.HomeActivity;
import jcv.com.mascotas.R;
import jcv.com.mascotas.localizados.LocalizadoActivity;
import jcv.com.mascotas.mascota.MascotaActivity;
import jcv.com.mascotas.usuario.PerfilActivity;

public class BottomNavigationViewHelper {

    public static void setUpBottomNavigationView(BottomNavigationView bottomNavigationView){

    }

    public static void enableBottomNavigationView(BottomNavigationView bottomNavigationView, final Context context) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        Intent intent_home = new Intent(context, HomeActivity.class);
                        context.startActivity(intent_home);
                        break;
                    case R.id.menu_localizado:
                        Intent intent_localizado = new Intent(context, LocalizadoActivity.class);
                        context.startActivity(intent_localizado);
                        break;
                    case R.id.menu_encontrar:
                        Intent intent_encontrar = new Intent(context, EncontrarActivity.class);
                        context.startActivity(intent_encontrar);
                        break;
                    case R.id.menu_mascota:
                        Intent intent_mascota = new Intent(context, MascotaActivity.class);
                        context.startActivity(intent_mascota);
                        break;
                    case R.id.menu_perfil:
                        Intent intent_perfil = new Intent(context, PerfilActivity.class);
                        context.startActivity(intent_perfil);
                        break;

                }

                return false;
            }
        });
    }
}
