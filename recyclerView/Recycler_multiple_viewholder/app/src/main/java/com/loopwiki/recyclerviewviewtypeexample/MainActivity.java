package com.loopwiki.recyclerviewviewtypeexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter adapter = new Adapter();
        adapter.setItems(LoadData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public List<ListItem> LoadData() {
        int[] image = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
                R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven,};
        String[] MovieName = {"Inside Out", "Padmaavat", "Bird box", "War", "Ferdinan", "Avatar",
                "Infinity war", "Oblivion", "I am lisa", "Tanaji", "Mission Managal"};

        String[] MovieYear = {"2001", "2016", "2005", "2011", "2008", "2014", "2012", "2020", "2018", "2005", "2011"};

        List<ListItem> items = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            Movie movie = new Movie();
            movie.setName(MovieName[i]);
            movie.setYear(MovieYear[i]);
            movie.setImage(image[i]);
            items.add(movie);
            if (i % 2 == 0) {
                Ad ad = new Ad();
                ad.setText("This is Ad");
                items.add(ad);
            }
        }
        return items;
    }


}
