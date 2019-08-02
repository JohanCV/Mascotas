package jcv.com.mascotas.mascota;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jcv.com.mascotas.R;
import jcv.com.mascotas.localizados.LocalizadoActivity;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

public class MascotaActivity extends AppCompatActivity {
    private static final String TAG = "MascotaActivity";
    private static final int ACTIVITY_NUM = 3;
    private Context mcontext = MascotaActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
