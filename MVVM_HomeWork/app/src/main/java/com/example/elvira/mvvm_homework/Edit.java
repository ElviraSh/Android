package com.example.elvira.mvvm_homework;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.elvira.mvvm_homework.databinding.ActivityEditBinding;


public class Edit extends AppCompatActivity {
    ActivityEditBinding binding;
    EditViewModel editViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit);
        super.onCreate(savedInstanceState);

        editViewModel = new EditViewModel();
        binding.setViewModel(editViewModel);
        editViewModel.setData(getIntent().getIntExtra("position", 0));

    }


}