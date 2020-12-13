package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity1 extends AppCompatActivity {

    EditText txt_iNombre,txt_iUser,txt_iPassw;
    BeanUser beanu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        txt_iNombre = findViewById(R.id.txt_iNombre);
        txt_iUser = findViewById(R.id.txt_iUser);
        txt_iPassw = findViewById(R.id.txt_iPassw);

        beanu = new BeanUser(this);
    }

    public void addUser_OnClick(View v){
        beanu.AddUser(
                txt_iNombre.getText().toString(),
                txt_iUser.getText().toString(),
                txt_iPassw.getText().toString()
        );
        Toast.makeText(this, "Usuario insertado ", Toast.LENGTH_LONG).show();
    }
}