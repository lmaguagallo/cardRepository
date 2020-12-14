package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity1 extends AppCompatActivity {

    EditText txt_iNombre,txt_iUser,txt_iPassw;
    BeanUser beanu;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);

        txt_iNombre = findViewById(R.id.txt_iNombre);
        txt_iUser = findViewById(R.id.txt_iUser);
        txt_iPassw = findViewById(R.id.txt_iPassw);
        user = new Usuario();
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

    public void addUsers_Onclick( View v) {
        String nombre_user = txt_iNombre.getText().toString();
        String usuario_word = txt_iUser.getText().toString();
        String password_user = txt_iPassw.getText().toString();
        System.out.println("Nombre-> "+ nombre_user + " usr->"+usuario_word+" pss->" +password_user );

        user.setNombre(nombre_user);
        user.setUsuario(usuario_word);
        user.setPassword(password_user);
        /*
        if( !beanu.checkUsuario(usuario_word)) {
            System.out.println("ok");
            //beanLogin.addUser(user);
            beanLogin.addUser(nombre_user, usuario_word, password_user);
            System.out.println("okok");
            Toast.makeText(this, "Usuario Creado ", Toast.LENGTH_LONG).show();
        }else {
            System.out.println("fail");
            Toast.makeText(this, "Ya existe "+ usuario_word + "! Cree otro.", Toast.LENGTH_LONG).show();
        }*/
        beanu.addUsers(user);
        Toast.makeText(this, "Usuario Creado ", Toast.LENGTH_LONG).show();
    }


}