package jcv.com.mascotas.publicaciones.adaptador;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.modelo.Mascota;
import jcv.com.mascotas.modelo.Publicacion;
import jcv.com.mascotas.modelo.PublicacionDetalle;
import jcv.com.mascotas.publicaciones.DetallePublicacionActivity;
import jcv.com.mascotas.publicaciones.HomeActivity;
import jcv.com.mascotas.publicaciones.HomeFragment;

public class PublicacionAdaptador extends RecyclerView.Adapter<PublicacionAdaptador.ViewHolderPublicacion> {
    private List<PublicacionDetalle> listPublicaciondetalle;
    private LayoutInflater mInflater;
    private Context context;

    public PublicacionAdaptador(Context context, List<PublicacionDetalle> listPublicaciondetalle){
        this.context = context;
        this.listPublicaciondetalle = listPublicaciondetalle;
        mInflater=LayoutInflater.from(context);
    }
    public class ViewHolderPublicacion extends RecyclerView.ViewHolder {

        TextView nombreMascota, fechaPublicacion, horaPublicacion;
        TextView  dondeMascota, recompensaMascota;
        ImageView  imgMascota;
        CardView card;
        int codigo;
        PublicacionAdaptador mAdapter_Publicacion;

        public ViewHolderPublicacion(@NonNull View itemView,final PublicacionAdaptador adapter) {
            super(itemView);

            nombreMascota = itemView.findViewById(R.id.lblNombreMascota);
            fechaPublicacion = itemView.findViewById(R.id.lblFechaPublicacion);
            horaPublicacion =itemView.findViewById(R.id.lblHoraPublicacion);

            imgMascota = itemView.findViewById(R.id.imgMascota);

            dondeMascota = itemView.findViewById(R.id.txtDondeInput);
            recompensaMascota = itemView.findViewById(R.id.txtPresupuestoInput);

            card=itemView.findViewById(R.id.cardview_publicacion);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(mAdapter_Publicacion.context,nombreMascota.getText(),Toast.LENGTH_LONG).show();
                    Intent irdetalle = new Intent(context, DetallePublicacionActivity.class);
                    irdetalle.putExtra("id_mascota",codigo);
                    context.startActivity(irdetalle);
                }
            });
            mAdapter_Publicacion=adapter;
        }
    }

    @NonNull
    @Override
    public ViewHolderPublicacion onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_publicacion_recycler,viewGroup,false);
        return new ViewHolderPublicacion(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPublicacion viewHolderPublicacion, int position) {
        Calendar c1 = GregorianCalendar.getInstance();
        viewHolderPublicacion.fechaPublicacion.setText(listPublicaciondetalle.get(position).getFecha_perdida().toString());
        viewHolderPublicacion.nombreMascota.setText(listPublicaciondetalle.get(position).getMascota().getNombre());
        viewHolderPublicacion.dondeMascota.setText(listPublicaciondetalle.get(position).getLatitud_perdida().toString());
        viewHolderPublicacion.recompensaMascota.setText(listPublicaciondetalle.get(position).getRecompensa().toString());
        viewHolderPublicacion.codigo = listPublicaciondetalle.get(position).getId();
        Log.e("Mascota", listPublicaciondetalle.get(position).getMascota().getId() +"");
        if(listPublicaciondetalle.get(position).getMascota().getFotomascota()!=null){
            Log.e("Mascota", "Entro");
            if (listPublicaciondetalle.get(position).getMascota().getFotomascota().size()>0){
                Log.e("Mascota", "Salio");
                Glide.with(context).load(listPublicaciondetalle.get(position).getMascota().getFotomascota().get(1).getFoto()).into(viewHolderPublicacion.imgMascota);
            }
        }
        //poner el de la publicacion de cada publicacion
        //servicio de login de willy

       }

    @Override
    public int getItemCount() {
        return listPublicaciondetalle.size();
    }
}
