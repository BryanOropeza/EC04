package com.bryan.ec04.fragments;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.ec04.databinding.ItemMenuResumeBinding;
import com.bryan.ec04.model.Dessert;
import com.bryan.ec04.model.MainPlate;
import com.bryan.ec04.model.MenuModel;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class RVResumeAdapter extends RecyclerView.Adapter<RVResumeAdapter.ResumeVH> {

    private List<MenuModel> menu;

    public RVResumeAdapter(List<MenuModel> menu) {
        this.menu = menu;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMenuResumeBinding binding = ItemMenuResumeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ResumeVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(menu.get(position));
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    class ResumeVH extends RecyclerView.ViewHolder {
        private ItemMenuResumeBinding binding;

        public ResumeVH(ItemMenuResumeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MenuModel menu){
            if (menu instanceof MainPlate){
                binding.textMenu.setVisibility(View.VISIBLE);
                binding.textMenu.setText(""+((MainPlate) menu).getUpdated_at());
                binding.textDescription.setVisibility(View.VISIBLE);
                binding.textDescription.setText(""+((MainPlate) menu).getDescription());
            } else if (menu instanceof Dessert) {
                binding.textMenu.setVisibility(View.VISIBLE);
                binding.textMenu.setText(""+((Dessert) menu).getUpdated_at());
                binding.textDescription.setVisibility(View.VISIBLE);
                binding.textDescription.setText(""+((Dessert) menu).getDsrt_description());
            }

            ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(menu.getRegular())
                    .crossfade(true)
                    .target(binding.imgMenu)
                    .build();

            imageLoader.enqueue(request);
        }
    }

}
