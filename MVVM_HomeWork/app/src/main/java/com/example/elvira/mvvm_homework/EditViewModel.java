package com.example.elvira.mvvm_homework;

import android.databinding.ObservableField;

import java.util.LinkedList;

/**
 * Created by Elvira on 11.03.2017.
 */

public class EditViewModel {
    LinkedList<User> users;
    public ObservableField<String> name;
    public ObservableField<String> surname;
    public ObservableField<String> email;
    int position;

    public EditViewModel() {
        users = GenerateUser.getGenerateUser().users();
        name = new ObservableField<>("");
        surname = new ObservableField<>();
        email = new ObservableField<>("");

    }

    public void setData(int position) {
        this.position = position;
        name.set(users.get(position).getName());
        surname.set(users.get(position).getSurname());
        email.set(users.get(position).getEmail());
    }

    public void click() {
        GenerateUser.getGenerateUser().newUser("" + name.get(), "" +surname.get(),""+ email.get(), position);
    }

}