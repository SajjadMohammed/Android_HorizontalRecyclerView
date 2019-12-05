package com.sajjad.horizontalrecyclerviewdemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    RecyclerView personRecycler;
    PersonRecyclerAdapter personRecyclerAdapter;
    List<PersonItemModel> personItemModels;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainToolbar = findViewById(R.id.mainToolbar);
        personRecycler = findViewById(R.id.personRecycler);

        setSupportActionBar(mainToolbar);

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        personRecycler.setLayoutManager(layoutManager);

        fillData();
    }

    private void fillData() {
        personItemModels = new ArrayList<>();
        personItemModels.add(new PersonItemModel(1, "Sajjad", 31));
        personItemModels.add(new PersonItemModel(2, "Ahmed", 28));
        personItemModels.add(new PersonItemModel(3, "Ameer", 24));
        personItemModels.add(new PersonItemModel(4, "Huda", 20));
        personItemModels.add(new PersonItemModel(5, "Aya", 30));
        personItemModels.add(new PersonItemModel(1, "Sajjad", 31));
        personItemModels.add(new PersonItemModel(2, "Ahmed", 28));
        personItemModels.add(new PersonItemModel(3, "Ameer", 24));
        personItemModels.add(new PersonItemModel(4, "Huda", 20));
        personItemModels.add(new PersonItemModel(5, "Aya", 30));
    }

    public void showRecyclerItems(View view) {
        personRecyclerAdapter = new PersonRecyclerAdapter(this, personItemModels);
        personRecycler.setItemAnimator(new DefaultItemAnimator());
        personRecycler.setAdapter(personRecyclerAdapter);

        new ItemTouchHelper(personRecyclerAdapter.swipeToDelete).attachToRecyclerView(personRecycler);
    }
}