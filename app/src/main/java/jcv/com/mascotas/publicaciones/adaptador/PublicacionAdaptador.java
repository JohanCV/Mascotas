package jcv.com.mascotas.publicaciones.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.modelo.Publicacion;

public class PublicacionAdaptador extends RecyclerView.Adapter<PublicacionAdaptador.ViewHolderPublicacion> {

    private Context context;
    private List<Publicacion> listPublicacion;

    public PublicacionAdaptador(Context context, List<Publicacion> listPublicacion){
        this.context = context;
        this.listPublicacion = listPublicacion;
    }

    @NonNull
    @Override
    public ViewHolderPublicacion onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_publicacion_recycler,viewGroup,false);
        return new ViewHolderPublicacion(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPublicacion viewHolderPublicacion, int position) {

        viewHolderPublicacion.fechaPublicacion.setText(listPublicacion.get(position).getFecha_perdida().toString());

        viewHolderPublicacion.nombreMascota.setText(listPublicacion.get(position).getEstado().toString());
        viewHolderPublicacion.dondeMascota.setText(listPublicacion.get(position).getLatitud_perdida().toString());
        viewHolderPublicacion.recompensaMascota.setText(listPublicacion.get(position).getRecompensa().toString());


    }

    @Override
    public int getItemCount() {
        return listPublicacion.size();
    }

    public class ViewHolderPublicacion extends RecyclerView.ViewHolder {

        TextView nombreMascota, fechaPublicacion, horaPublicacion;
        TextView  dondeMascota, recompensaMascota;

        ImageView  imgMascota;

        public ViewHolderPublicacion(@NonNull View itemView) {
            super(itemView);


            nombreMascota = itemView.findViewById(R.id.lblNombreMascota);
            fechaPublicacion = itemView.findViewById(R.id.lblFechaPublicacion);
            horaPublicacion =itemView.findViewById(R.id.lblHoraPublicacion);

            imgMascota = itemView.findViewById(R.id.imgMascota);
            dondeMascota = itemView.findViewById(R.id.txtDondeInput);
            recompensaMascota = itemView.findViewById(R.id.txtPresupuestoInput);
        }
    }
}
