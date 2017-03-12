package com.example.elvira.mvp_homework;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Item extends AppCompatActivity {

    TextView name;
    TextView surname;
    TextView email;
    Intent intent;
    Dialog dialog;
    Button change;
    Button btn;
    PresenterItem presenterItem;

    EditText name1;
    EditText surname1;
    EditText email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit);

        presenterItem = new PresenterItem((UserItem) this);

        name = (TextView) findViewById(R.id.name);
        surname = (TextView) findViewById(R.id.surname);
        email = (TextView) findViewById(R.id.email);
        change = (Button) findViewById(R.id.change);

        name1 = (EditText) dialog.findViewById(R.id.name2);
        surname1 = (EditText) dialog.findViewById(R.id.surname2);
        email1 = (EditText) dialog.findViewById(R.id.email2);

        intent = getIntent();
        presenterItem.setNewData(intent);


        btn = (Button) dialog.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogConfirmButtonClick();
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeClick();
            }
        });


    }


    public void changeClick() {
        name1.setText(name.getText());
        surname1.setText(surname.getText());
        email1.setText(email.getText());
        dialog.show();
    }

    public void dialogConfirmButtonClick() {
        presenterItem.saveNewInfo(name1.getText().toString(), surname1.getText().toString(), email1.getText().toString(), intent.getIntExtra("id", 0));
        presenterItem.setNewData();
        dialog.cancel();

    }


}
