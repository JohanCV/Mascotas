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

        viewHolderPublicacion.fecha.setText(listPublicacion.get(position).getFecha_perdida().toString());
        viewHolderPublicacion.nombreMascota.setText(listPublicacion.get(position).getFecha_perdida().toString());
        viewHolderPublicacion.dondeMascota.setText(listPublicacion.get(position).getLatitud_perdida().toString());
        viewHolderPublicacion.recompensaMascota.setText(listPublicacion.get(position).getRecompensa().toString());
    }

    @Override
    public int getItemCount() {
        return listPublicacion.size();
    }

    public class ViewHolderPublicacion extends RecyclerView.ViewHolder {

        TextView nombreUsuario, fecha, hora;
        TextView nombreMascota, dondeMascota, recompensaMascota;

        ImageView imgUser, imgMascota;

        public ViewHolderPublicacion(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.imgUsuario);
            nombreUsuario = itemView.findViewById(R.id.txtNombreUsurio);
            fecha = itemView.findViewById(R.id.txtFecha);
            hora =itemView.findViewById(R.id.txtHora);

            imgMascota = itemView.findViewById(R.id.imgMascota);
            nombreMascota = itemView.findViewById(R.id.txtNombreMascotaInput);
            dondeMascota = itemView.findViewById(R.id.txtDondeInput);
            recompensaMascota = itemView.findViewById(R.id.txtPresupuestoInput);
        }
    }
}
