package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_user,txt_passw;
    BeanUser beanu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_user = findViewById(R.id.txt_user);
        txt_passw = findViewById(R.id.txt_passw);

        //beanu = new BeanUser(this);

    }

    public void RegisterPage_OnClick(View v) {
        Intent registerAccount;
        registerAccount = new Intent(this, RegisterActivity1.class);
        //inicar activity
        startActivity(registerAccount);

    }

    public void MenuPagefromLogin_OnClick(View v) {
        Intent menuAccount;
        menuAccount = new Intent(this, MenuActivity.class);
        //inicar activity
        startActivity(menuAccount);

    }


}