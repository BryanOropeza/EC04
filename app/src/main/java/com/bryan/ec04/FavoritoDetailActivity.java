package com.bryan.ec04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bryan.ec04.data.db.ShowsRepository;
import com.bryan.ec04.fragments.FavoritoAdapter;

import java.util.ArrayList;

public class FavoritoDetailActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FavoritoAdapter favoritoAdapter;
    private ShowsRepository showsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_detail);

        recyclerView = findViewById(R.id.rcvFavorites);
        showsRepository = new ShowsRepository(getApplication());

        // Configura el RecyclerView
        setupRecyclerView();

        // Observa los cambios en los favoritos y actualiza el adaptador
        showsRepository.getAll().observe(this, favoritos -> {
            favoritoAdapter.setFavoritos(favoritos);
        });
    }

    private void setupRecyclerView() {
        // Configura el LinearLayoutManager (puede ser GridLayoutManager si prefieres una cuadrícula)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Crea el adaptador y asigna al RecyclerView
        favoritoAdapter = new FavoritoAdapter(new ArrayList<>()); // Pasa una lista vacía por ahora
        recyclerView.setAdapter(favoritoAdapter);
    }
}

