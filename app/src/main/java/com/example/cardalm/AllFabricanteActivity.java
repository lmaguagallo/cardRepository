package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class AllFabricanteActivity extends AppCompatActivity {

    TableLayout tbl_table;

    // Datos de base de datos
    BeanFabricante beanF;
    //Compnetes de tabla
    TableComponets tableModel;

    //VARIABLEAS
    // Nombres de las columnas
    String[] titles = {"ID","Fabricante", "Pais"};

    Fabricante[] allFabricantes;
    ArrayList<String[]> allRowFabricantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_fabricante);

        //Ocutar barra superior
        getSupportActionBar().hide();
        //Instanciar la tabla de vista
        tbl_table = findViewById(R.id.tbl_allVehiculos);

        // Instanciat clases
        beanF = new BeanFabricante(this);
        tableModel = new TableComponets(tbl_table,this);

        // Asigar Etiquetas a colunas
        tableModel.AddTableTitle(titles);

        //LLenar lista
        allFabricantes = beanF.SelectAllFab();
        if (allFabricantes != null){
            //printFabricantes(allFabricantes);
            tableModel.addData(getAllFabricantes(allFabricantes));
        }else {
            Toast.makeText(this, "No hay datos ", Toast.LENGTH_LONG).show();
        }

        // Color de Columnas
        tableModel.backgroundHeader(Color.parseColor("#1F6155"));
    }


    private ArrayList<String[]> getAllFabricantes(Fabricante[] allFabricantes){
        for(int i = 0; i < allFabricantes.length; i++){
            allRowFabricantes.add(new String[]{
                    allFabricantes[i].IdFabricante +"",
                    allFabricantes[i].NombreFabricante,
                    allFabricantes[i].Pais
            });
        }
        return allRowFabricantes;
    }

    private void printFabricantes(Fabricante[] allFabricantes){
        for(int i = 0; i < allFabricantes.length; i++){
            System.out.println(
                    allFabricantes[i].IdFabricante +" "+
                    allFabricantes[i].NombreFabricante + " "+
                    allFabricantes[i].Pais
            );
        }
    }


}