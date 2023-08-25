package com.bryan.ec04.data.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.bryan.ec04.model.ShowEntity;

import java.util.List;

public class ShowsRepository {

    private ShowDao dao;
    private EnarTasteDatabase db;

    public ShowsRepository(Application application) {
        db = EnarTasteDatabase.getInstance(application);
        dao = db.showDao();
    }

    public void addShow(ShowEntity showEntity){
        EnarTasteDatabase.dataBaseWriteExecutor.execute(() ->
                dao.addShow(showEntity));
    }

    public LiveData<List<ShowEntity>> getAll(){
        return dao.getAll();
    }
}
