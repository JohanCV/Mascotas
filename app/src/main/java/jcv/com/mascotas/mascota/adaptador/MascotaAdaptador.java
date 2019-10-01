package jcv.com.mascotas.mascota.adaptador;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import jcv.com.mascotas.R;
import jcv.com.mascotas.modelo.Mascota;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.VHMascota> implements View.OnClickListener{
    private Context context;
    private List<Mascota> listMascotas;
    private View.OnClickListener listener;

    public MascotaAdaptador(Context context, List<Mascota> listMascotas) {
        this.context = context;
        this.listMascotas = listMascotas;
    }

    @NonNull
    @Override
    public VHMascota onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        view.setOnClickListener(this);
        return new VHMascota(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VHMascota holder, int position) {
        holder.nombre.setText(listMascotas.get(position).getNombre());
        holder.raza.setText(String.valueOf(listMascotas.get(position).getRaza()));
        holder.observacion.setText(listMascotas.get(position).getObservaciones());
        if(listMascotas.get(position).getFotomascota() != null) {
//            Log.e("ErrorMascota", listMascotas.get(position).getFotomascota().get(0).getFoto() );
            if(listMascotas.get(position).getFotomascota().size() >0)
            Glide.with(context).load(listMascotas.get(position).getFotomascota().get(0).getFoto()).into(holder.foto);
        }
        //holder.foto.setImageBitmap(listMascotas.get(position).getFotomascota());

    }

    @Override
    public int getItemCount() {
        return listMascotas.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if (listener!= null)
            listener.onClick(view);
    }

    public class VHMascota extends RecyclerView.ViewHolder{

        TextView nombre, raza, observacion;
        ImageView foto;

        public VHMascota(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.txtNombreMascotaPerfilInput);
            raza = (TextView) itemView.findViewById(R.id.txtRazaMascotaPerfilInput);
            observacion = (TextView) itemView.findViewById(R.id.txtObservacionesMAscotaPerfilInput);
            foto=(ImageView)itemView.findViewById(R.id.imgMascotaperfil);


        }
    }
}
