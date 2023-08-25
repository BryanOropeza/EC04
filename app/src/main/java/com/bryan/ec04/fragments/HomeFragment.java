package com.bryan.ec04.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bryan.ec04.data.retrofit.RetrofitHelper;
import com.bryan.ec04.data.retrofit.response.ShowResponse;
import com.bryan.ec04.databinding.FragmentHome2Binding;
import com.bryan.ec04.model.MainPlate;
import com.bryan.ec04.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHome2Binding binding;
    private HomeViewModel homeViewModel;
    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(HomeViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.rcvPlatesMenu.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rcvPlatesMenu.setLayoutManager(layoutManager);

        RetrofitHelper.getService().getMenus().enqueue(new Callback<ShowResponse>() {
            @Override
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    showMenu(response.body().getMenuList());

                }
            }

            @Override
            public void onFailure(Call<ShowResponse> call, Throwable t) {

            }
        });
        homeViewModel.listLiveData.observe(requireActivity(),showList ->{
            //mostrar en recyble
            for(int i = 0; i < showList.size(); i++){
                Log.d("shows:", showList.get(i).getUpdated_at());
            }
        });
        homeViewModel.getShows();




    }
    private void showMenu(List<MenuModel> menuList) {
        RVMenuAdapter adapter = new RVMenuAdapter(menuList, menu -> {
            homeViewModel.addShow(menu);
        });
        binding.rcvMenus.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHome2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    private List<MenuModel> getData() {
        List<MenuModel> menu = new ArrayList<>();
        menu.add(new MainPlate("10-02-23","https://images.unsplash.com/photo-1469474968028-56623f02e42e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1474&q=80", "","Hermoso Paisaje", "","238",""));
        menu.add(new MainPlate("24-08-22","https://images.unsplash.com/photo-1433086966358-54859d0ed716?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80", "","Vista relajante","","238",""));
        menu.add(new MainPlate("14-03-21","https://images.unsplash.com/photo-1586348943529-beaae6c28db9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1315&q=80", "","Perfect Place","","238",""));
        menu.add(new MainPlate("21-05-23","https://plus.unsplash.com/premium_photo-1673264933212-d78737f38e48?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80", "","The best place to relax","","238",""));
        menu.add(new MainPlate("23-07-22","https://images.unsplash.com/photo-1426604966848-d7adac402bff?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80", "","El mejor lugar","","238",""));
        menu.add(new MainPlate("08-12-21","https://images.unsplash.com/photo-1475924156734-496f6cac6ec1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80", "","Relajante","","238",""));
        menu.add(new MainPlate("12-08-22","https://images.unsplash.com/photo-1505144808419-1957a94ca61e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1526&q=80", "","Grandioso paisaje","","238",""));
        menu.add(new MainPlate("23-10-21","https://images.unsplash.com/photo-1510784722466-f2aa9c52fff6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80", "","La mejor experiencia","","238",""));
        menu.add(new MainPlate("05-10-20","https://images.unsplash.com/photo-1439853949127-fa647821eba0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80", "","Tranquilidad","","238",""));
        menu.add(new MainPlate("30-12-21","https://images.unsplash.com/photo-1444464666168-49d633b86797?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1469&q=80", "","Buen espacio","","238",""));
        return menu;
    }
}