package com.example.elvira.mvvm_homework;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Elvira on 11.03.2017.
 */

public class ViewModel {
    Context context;

    public ViewModel(Context context){
        this.context = context;
    }


    public void click (int position){
        Intent intent = new Intent(context, Edit.class);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }
}