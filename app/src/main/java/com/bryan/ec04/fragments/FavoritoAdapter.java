package com.bryan.ec04.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.ec04.databinding.ItemFavoritoBinding;
import com.bryan.ec04.model.ShowEntity;
import com.bumptech.glide.Glide;

import java.util.List;

public class FavoritoAdapter extends RecyclerView.Adapter<FavoritoAdapter.FavoritoViewHolder> {
    private List<ShowEntity> favoritos;

    public FavoritoAdapter(List<ShowEntity> favoritos) {
        this.favoritos = favoritos;
    }

    @NonNull
    @Override
    public FavoritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFavoritoBinding binding = ItemFavoritoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoritoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritoViewHolder holder, int position) {
        holder.bind(favoritos.get(position));
    }

    @Override
    public int getItemCount() {
        return favoritos.size();
    }

    public void setFavoritos(List<ShowEntity> favoritos) {
        this.favoritos = favoritos;
        notifyDataSetChanged(); // Notifica al adaptador sobre los cambios en los datos
    }

    public class FavoritoViewHolder extends RecyclerView.ViewHolder {

        private ItemFavoritoBinding binding;

        public FavoritoViewHolder(@NonNull ItemFavoritoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ShowEntity favorito) {
            binding.txtFavoritoName.setText(favorito.getUpdated_at());
            Glide.with(itemView.getContext()).load(favorito.getRegular()).into(binding.imgFavorito);
        }
    }
}