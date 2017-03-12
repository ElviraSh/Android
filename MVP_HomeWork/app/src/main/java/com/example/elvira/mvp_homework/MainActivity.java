package com.example.elvira.mvp_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ModelUserPresenter modelUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        modelUserPresenter = new ModelUserPresenter(this, recyclerView, this);


        modelUserPresenter.setList();


    }

    @Override
    protected void onResume() {
        super.onResume();
        modelUserPresenter.setList();
    }




}