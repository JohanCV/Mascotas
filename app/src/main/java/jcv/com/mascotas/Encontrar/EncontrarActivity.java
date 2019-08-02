package jcv.com.mascotas.Encontrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import jcv.com.mascotas.R;
import jcv.com.mascotas.utils.BottomNavigationViewHelper;

public class EncontrarActivity extends AppCompatActivity {
    private static final String TAG = "EncontrarActivity";
    private static final int ACTIVITY_NUM = 2;
    private Context mcontext = EncontrarActivity.this;
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationViewHelper bottomNavigationViewHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
