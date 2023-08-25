package com.bryan.ec04.fragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bryan.ec04.data.db.ShowsRepository;
import com.bryan.ec04.model.MenuModel;
import com.bryan.ec04.model.ShowEntity;

import java.util.List;


public class HomeViewModel extends AndroidViewModel {

    private ShowsRepository repository;
    public LiveData<List<ShowEntity>> listLiveData = new MutableLiveData<List<ShowEntity>>();

    public HomeViewModel(@NonNull Application application ) {
        super(application);
        repository = new ShowsRepository(application);
    }


    public void addShow(MenuModel show) {
        ShowEntity showEntity = new ShowEntity();
        showEntity.setUpdated_at(show.getUpdated_at());
        showEntity.setRegular(show.getRegular());
        repository.addShow(showEntity);
    }

    public void getShows() {
        listLiveData = repository.getAll();
    }

    public static class HomeViewModelFactory implements ViewModelProvider.Factory {

        private final Application application;

        public HomeViewModelFactory(Application myapplication){
            application = myapplication;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new HomeViewModel(application);
        }
    }
}
