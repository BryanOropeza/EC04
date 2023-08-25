package com.bryan.ec04.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.ec04.databinding.ItemShowBinding;
import com.bryan.ec04.model.MenuModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class RVMenuAdapter extends RecyclerView.Adapter<RVMenuAdapter.ShowViewHolder> {
    private List<MenuModel> menu;
    private FavoriteClick favoriteClick;

    public RVMenuAdapter(List<MenuModel> menu, FavoriteClick favoriteClick) {
        this.menu = menu;
        this.favoriteClick = favoriteClick;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowBinding binding = ItemShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ShowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        holder.bind(menu.get(position));
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }


    public class ShowViewHolder extends RecyclerView.ViewHolder{

        private ItemShowBinding binding;

        public ShowViewHolder(@NonNull ItemShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MenuModel menu) {
            binding.txtName.setText(menu.getUpdated_at());
            binding.btnFavorito.setOnClickListener(view -> {
                favoriteClick.onClick(menu);
            });
            Glide.with(itemView.getContext()).load(menu.getRegular()).into(binding.imgShow);


        }
    }

    public interface FavoriteClick {
        public void onClick(MenuModel menu);
    }
}


