package com.example.elvira.mvp_homework;

import android.content.Intent;

/**
 * Created by Elvira on 12.03.2017.
 */

class PresenterItem {
    UserItem userItem;
    GenerateUser generateUser;

    public PresenterItem(UserItem userItem) {
        this.userItem = userItem;
    }


    public void saveNewInfo(String name, String surname, String email, int id){
        generateUser = GenerateUser.getInstance();
        generateUser.newInfo(name, surname, email, id);

    }

    public void setNewData(Intent intent) {
        userItem.setData(intent.getStringExtra("name"), intent.getStringExtra("surname"), intent.getStringExtra("email"));
    }

    public void setNewData() {
        userItem.setDialogData();
    }


}