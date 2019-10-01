package jcv.com.mascotas.publicaciones.adaptador;

import android.content.Context;
import android.content.Intent;
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
import jcv.com.mascotas.publicaciones.DetallePublicacionActivity;
import jcv.com.mascotas.publicaciones.HomeActivity;
import jcv.com.mascotas.publicaciones.HomeFragment;

public class PublicacionAdaptador extends RecyclerView.Adapter<PublicacionAdaptador.ViewHolderPublicacion> {
    private List<Publicacion> listPublicacion;
    private LayoutInflater mInflater;
    private Context context;



    public PublicacionAdaptador(Context context, List<Publicacion> listPublicacion){
        this.context = context;
        this.listPublicacion = listPublicacion;
        mInflater=LayoutInflater.from(context);
    }
    public class ViewHolderPublicacion extends RecyclerView.ViewHolder {

        TextView nombreMascota, fechaPublicacion, horaPublicacion;
        TextView  dondeMascota, recompensaMascota;
        ImageView  imgMascota;
        CardView card;
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

                    Toast.makeText(mAdapter_Publicacion.context,nombreMascota.getText(),Toast.LENGTH_LONG).show();
                    Intent irdetalle = new Intent(context, DetallePublicacionActivity.class);
                    //irdetalle.putExtra("id_publicacion",listPublicacion.get(getPosition().get))
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


        viewHolderPublicacion.fechaPublicacion.setText(listPublicacion.get(position).getFecha_perdida().toString());
        viewHolderPublicacion.nombreMascota.setText(listPublicacion.get(position).getMascota().getNombre());
        viewHolderPublicacion.dondeMascota.setText(listPublicacion.get(position).getLatitud_perdida().toString());
        viewHolderPublicacion.recompensaMascota.setText(listPublicacion.get(position).getRecompensa().toString());
//        Glide.with(context).load(listPublicacion.get(position).getMascota().getFotomascota().get(1));

       }

    @Override
    public int getItemCount() {
        return listPublicacion.size();
    }
}
