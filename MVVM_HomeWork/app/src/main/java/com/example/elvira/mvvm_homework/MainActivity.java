package com.example.elvira.mvvm_homework;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.elvira.mvvm_homework.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ViewModel viewModel;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModel(this);
        super.onCreate(savedInstanceState);


        adapter = new Adapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new Adapter();
        binding.recyclerView.setAdapter(adapter);
    }
}