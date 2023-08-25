package com.bryan.ec04.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bryan.ec04.model.ShowEntity;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShowEntity.class}, version = 1)
public abstract class EnarTasteDatabase extends RoomDatabase {
    public abstract ShowDao showDao();

    private static volatile EnarTasteDatabase db;
    public static final ExecutorService dataBaseWriteExecutor = Executors.newFixedThreadPool(4);
    public static  EnarTasteDatabase getInstance(Context context){
        if (db == null){
            synchronized(EnarTasteDatabase.class){
                if(db == null){
                    db = Room.databaseBuilder(context.getApplicationContext(), EnarTasteDatabase.class,"shows-database").build();
                }
            }
        }
        return db;
    }
}
