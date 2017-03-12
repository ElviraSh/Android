package com.example.elvira.mvp_homework;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Elvira on 12.03.2017.
 */

class GenerateUser {
    private static GenerateUser instance;
    LinkedList<User> users;
    String[] name = {"Elvira", "Polina", "Ekaterina"};
    String[] surname = {"Shalafaeva", "Fedorova", "Boeva"};
    String[] email = {"elvira@mail.ru", "polya@mail.ru", "katya@mail.ru"};

    private GenerateUser() {
        refreshUsers();
    }


    public LinkedList<User> users() {

        return users;
    }

    private void refreshUsers() {
        users = new LinkedList<User>();
        String buf;
        int randomNumber;
        Random random = new Random();
        User user;
        for (int i = 0; i < 10; i++) {
            buf = name[i];
            randomNumber = random.nextInt(10);
            name[i] = name[randomNumber];
            name[randomNumber] = buf;

            buf = surname[i];
            randomNumber = random.nextInt(10);
            surname[i] = surname[randomNumber];
            surname[randomNumber] = buf;

            buf = email[i];
            randomNumber = random.nextInt(10);
            email[i] = email[randomNumber];
            email[randomNumber] = buf;
        }
        for (int i = 0; i < 10; i++) {
            user = new User(name[i], surname[i], email[i]);
            users.add(user);
        }
    }

    public static GenerateUser getInstance() {
        if(instance == null) {
            instance = new GenerateUser();
        }
        return instance;
    }

    public void newInfo(String name, String surname, String email, int id) {
        users.get(id).setName(name);
        users.get(id).setSurname(surname);
        users.get(id).setEmail(email);
    }




}
