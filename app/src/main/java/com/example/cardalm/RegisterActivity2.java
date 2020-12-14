package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {
    // Componentes de Vista
    EditText txt_nombreUser,txt_wordUser,txt_passwUser;
    //Adminstracion de Datos
    BeanUser beanu;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // Instaciar componentes
        txt_nombreUser = findViewById(R.id.txt_nombreUser);
        txt_wordUser = findViewById(R.id.txt_wordUser);
        txt_passwUser = findViewById(R.id.txt_passwUser);

        user = new Usuario();
        beanu = new BeanUser(this);
    }

    public void addUsers_Onclick( View v) {

        System.out.println("Nombre-> "+ txt_nombreUser.getText().toString() +
                " usr-> "+txt_wordUser.getText().toString()+
                " pss->" +txt_passwUser.getText().toString() );

        user.setNombre(txt_nombreUser.getText().toString());
        user.setUsuario(txt_wordUser.getText().toString());
        user.setPassword(txt_passwUser.getText().toString());
        /*
        if( !beanu.checkUsuario(txt_wordUser.getText().toString())) {
            System.out.println("ok1");
            executeInserUser(user);
            //Toast.makeText(this, "Usuario Creado ", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Ya existe "+ txt_wordUser.getText().toString() + "! Cree otro.", Toast.LENGTH_LONG).show();
        }*/
        beanu.addUsers(user);
        Toast.makeText(this, "Usuario Creado ", Toast.LENGTH_LONG).show();

    }
    

    public void updateUser_Onclick(View v) {
        String nombreU = txt_nombreUser.getText().toString();
        String userWord = txt_wordUser.getText().toString();
        String passwordU = txt_wordUser.getText().toString();

        if (!nombreU.equals("") && !userWord.equals("") && !passwordU.equals("")) {
            /*if( !beanu.checkUsuario(userWord)) {

            }else{
                Toast.makeText(this, "Ya existe "+ userWord + "! Cree otro.", Toast.LENGTH_LONG).show();
            }*/
            user.setNombre(nombreU);
            user.setUsuario(userWord);
            user.setPassword(passwordU);
            beanu.updateUsuario(user);
            Toast.makeText(this, "Usuario Actualizado ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Campos vacios! No se puede actualizar! ", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteUser_onclick(View v) {
        String nombreU = txt_nombreUser.getText().toString();
        String userWord = txt_wordUser.getText().toString();
        String passwordU = txt_passwUser.getText().toString();

        if (!nombreU.equals("") && !userWord.equals("") && !passwordU.equals("")) {
            /*if( !beanu.checkUsuario(userWord)) {

            }else{
                Toast.makeText(this, "No existe el usuario "+ userWord , Toast.LENGTH_LONG).show();
            }*/
            user.setNombre(nombreU);
            user.setUsuario(userWord);
            user.setPassword(passwordU);
            beanu.deleteUsuario(user);
            Toast.makeText(this, "Usuario Eliminado ", Toast.LENGTH_LONG).show();
            txt_nombreUser.setText("");
            txt_wordUser.setText("");
            txt_passwUser.setText("");

        } else {
            Toast.makeText(this, "Campos vacios! No se puede eliminar! ", Toast.LENGTH_LONG).show();
        }
    }

    public void selectOne_Onclick(View v) {
        String userWord = txt_wordUser.getText().toString();

        if (!userWord.equals("") ) {
            /*if( !beanu.checkUsuario(userWord)) {

            }else{
                Toast.makeText(this, "No existe el usuario "+ userWord , Toast.LENGTH_LONG).show();
            }*/
            user =  beanu.selectOneUser(userWord);
            if (user != null) {
                txt_nombreUser.setText(user.Nombre);
                txt_passwUser.setText(user.Password);
                Toast.makeText(this, "Hecho ", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "No se encontraron ningun registro!" , Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "La busqueda se realiza por el USUARIO! ", Toast.LENGTH_LONG).show();
        }
    }

    public void selectByUser_Onclick (View v){
        String userWord = txt_wordUser.getText().toString();

        if (!userWord.equals("") ) {
            Usuario[] u = beanu.selectByUserWord(userWord);
            if (u != null){
                txt_nombreUser.setText(""+u[0].Nombre);
                txt_passwUser.setText(""+u[0].Password);
                Toast.makeText(this, "Se encontraron "+ u.length + " registros!" , Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No se encontraron ningun registro!" , Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "La busqueda se realiza por el USUARIO! ", Toast.LENGTH_LONG).show();
        }

    }


}