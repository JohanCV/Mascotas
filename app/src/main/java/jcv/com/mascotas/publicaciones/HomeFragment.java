package jcv.com.mascotas.publicaciones;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.mascota.CrearPerfilMascotaActivity;
import jcv.com.mascotas.modelo.PublicacionDetalle;
import jcv.com.mascotas.publicaciones.adaptador.PublicacionAdaptador;
import jcv.com.mascotas.modelo.Publicacion;
import jcv.com.mascotas.servicios.ServicioPublicacion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    public static String url = "http://proyectosmovil.pythonanywhere.com";
    private RecyclerView recyclerView;
    private PublicacionAdaptador publicacionAdaptador;
    private List<PublicacionDetalle> listPublish = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.rv_publicaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //llenarListaBaseDatos();


        floatingActionButton = view.findViewById(R.id.floatingActionButtonPublicar);

        coneccion();
        events();

        return view;
    }

    private void coneccion() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServicioPublicacion servicioPublicacion =retrofit.create(ServicioPublicacion.class);
        Call<List<PublicacionDetalle>> call =servicioPublicacion.listarPublicacion();

        call.enqueue(new Callback<List<PublicacionDetalle>>() {
            @Override
            public void onResponse(Call<List<PublicacionDetalle>> call, Response<List<PublicacionDetalle>> response) {
                switch (response.code()){
                    case 200:
                        List<PublicacionDetalle> publicaciones = response.body();
                        publicacionAdaptador = new PublicacionAdaptador(getContext(),publicaciones);
                        recyclerView.setAdapter(publicacionAdaptador);
                        for(PublicacionDetalle p : publicaciones){
                            Log.d("mascota", p.getRecompensa()+"");
                            Log.d("mascota", p.getFecha_perdida()+"");
                            Log.d("mascota", p.getLatitud_perdida()+"");
                            Log.d("mascota", p.getLongitud_perdida()+"");
                        }
                        break;
                }
            }

            @Override
            public void onFailure(Call<List<PublicacionDetalle>> call, Throwable t) {
            }
        });
    }

    private void events(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcrearpublicacion = new Intent(getContext(), CrearPublicacionActivity.class);
                startActivity(intentcrearpublicacion);
            }
        });
    }

    private void showPopupPublicar(){

    }
    /*
    private void llenarListaBaseDatos(){
        listPublish.add(new Publicacion("img","user1","22/06/19","10:45"
                ,"Firulais","husky-siberiano","cafe-oscuro","mediano"
                ,"collar en forma de hueso","av. eeuu","manchas rojas","ninguna"));

        listPublish.add(new Publicacion("img","user2","22/06/19","10:45"
                ,"Firulais","husky-siberiano","cafe-oscuro","mediano"
                ,"collar en forma de hueso","av. eeuu","manchas rojas","ninguna"));
        listPublish.add(new Publicacion("img","user3","22/06/19","10:45"
                ,"Firulais","husky-siberiano","cafe-oscuro","mediano"
                ,"collar en forma de hueso","av. eeuu","manchas rojas","ninguna"));
    }
    */
}
