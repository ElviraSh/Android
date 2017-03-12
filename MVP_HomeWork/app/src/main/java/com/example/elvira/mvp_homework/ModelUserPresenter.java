package com.example.elvira.mvp_homework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Elvira on 12.03.2017.
 */

class ModelUserPresenter {

    RecyclerView recyclerView;
    GenerateUser generateUser;
    UserAdapter userAdapter;
    Context context;

    public ModelUserPresenter(MainActivity mainActivity, RecyclerView recyclerView, Context context) {
        this.recyclerView = recyclerView;
        generateUser = GenerateUser.getInstance();
        this.context = context;

    }

    public void setList() {

        userAdapter = new UserAdapter(generateUser.users(), this.context);
        recyclerView.setAdapter(userAdapter);
    }


}
