package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class AllUsersActivity extends AppCompatActivity {

    TableLayout tbl_allUsers;

    // Datos de base de datos
    BeanUser beanU;
    //Compnetes de tabla
    TableComponets tableModel;

    //VARIABLEAS
    // Nombres de las columnas
    String[] titles = {"ID","Nombres", "Usuario","Contraseña"};

    Usuario[] allUsuarios;
    ArrayList<String[]> allRowUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        //Ocutar barra superior
        getSupportActionBar().hide();
        //Instanciar la tabla de vista
        tbl_allUsers = findViewById(R.id.tbl_allUsers);

        // Instanciat clases
        beanU = new BeanUser(this);
        tableModel = new TableComponets(tbl_allUsers,this);

        // Asigar Etiquetas a colunas
        tableModel.AddTableTitle(titles);

        //LLenar lista
        allUsuarios = beanU.SelectAllUsuarios();
        if (allUsuarios != null){
            //printFabricantes(allFabricantes);
            tableModel.addData(getAllUsers(allUsuarios));
        }else {
            Toast.makeText(this, "No hay datos ", Toast.LENGTH_LONG).show();
        }

        // Color de Columnas
        tableModel.backgroundHeader(Color.parseColor("#1F6155"));
    }

    private ArrayList<String[]> getAllUsers(Usuario[] allusers){
        for(int i = 0; i < allusers.length; i++){
            allRowUsuarios.add(new String[]{
                    allusers[i].Id +"",
                    allusers[i].Nombre,
                    allusers[i].Usuario,
                    allusers[i].Password
            });
        }
        return allRowUsuarios;
    }
}