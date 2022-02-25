package cl.desafiolatam.pruebasuperheroes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.pruebasuperheroes.R;
import cl.desafiolatam.pruebasuperheroes.databinding.ItemListBinding;
import cl.desafiolatam.pruebasuperheroes.modelo.Superheroe;

public class SupersAdapter extends RecyclerView.Adapter<SupersAdapter.CustomViewHolder> {
    private List<Superheroe> lista;
    private OnClickListener listener;

    public SupersAdapter() {
        lista = new ArrayList<>();
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void setLista(List<Superheroe> lista) {
        this.lista = lista;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bindData(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public interface OnClickListener {
        void onClickListener(Superheroe item);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private ItemListBinding b;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            b = ItemListBinding.bind(itemView);
        }

        public void bindData(Superheroe item) {
            Picasso.get().load(item.getImages().getMd()).into(b.imgHeroe);
            b.txtNombreHeroe.setText(item.getName());
            itemView.setOnClickListener(v -> listener.onClickListener(item));
        }
    }
}


