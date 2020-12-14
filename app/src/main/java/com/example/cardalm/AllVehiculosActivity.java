package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class AllVehiculosActivity extends AppCompatActivity {

    TableLayout tbl_allVehiculos;

    // Datos de base de datos
    BeanFabricante beanF;
    //Compnetes de tabla
    TableComponets tableModel;

    //VARIABLEAS
    // Nombres de las columnas
    String[] titles = {"ID","Marca", "Fabricante","Modelo","Año","Cilindraje","Combustible"};

    Vehiculo[] allVehiculos;
    ArrayList<String[]> allRowVehiculos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_vehiculos);

        //Ocutar barra superior
        getSupportActionBar().hide();
        //Instanciar la tabla de vista
        tbl_allVehiculos = findViewById(R.id.tbl_allUsers);

        // Instanciat clases
        beanF = new BeanFabricante(this);
        tableModel = new TableComponets(tbl_allVehiculos,this);

        // Asigar Etiquetas a colunas
        tableModel.AddTableTitle(titles);

        //LLenar lista
        allVehiculos = beanF.SelectAllVehiculos();
        if (allVehiculos != null){
            tableModel.addData(getVehiculos(allVehiculos));
        }else {
            Toast.makeText(this, "No hay datos ", Toast.LENGTH_LONG).show();
        }
        // Color de Columnas
        tableModel.backgroundHeader(Color.parseColor("#1F6155"));
    }

    /**
     * Método para converson de Vehiculo[] a ArrayList<Sting[]>
     * @param allVehiculos
     * @return ArrayList<Sting[]>
     */
    private ArrayList<String[]> getVehiculos(Vehiculo[] allVehiculos){
        for(int i = 0; i < allVehiculos.length; i++){
            allRowVehiculos.add(new String[]{
                    allVehiculos[i].IdVehiculo +"",
                    allVehiculos[i].Marca,
                    allVehiculos[i].IdFabricante+"",
                    allVehiculos[i].Modelo,
                    allVehiculos[i].AnioVehiculo+"",
                    allVehiculos[i].Cilindraje+"",
                    allVehiculos[i].Combustible
            });
        }
        return allRowVehiculos;
    }


    public void pint(Vehiculo[] allVehiculos){
        for(int i = 0; i < allVehiculos.length; i++){
            System.out.println(
                    allVehiculos[i].IdVehiculo + " "+
                            allVehiculos[i].Marca + " "+
                            allVehiculos[i].IdFabricante+ " "+
                            allVehiculos[i].Modelo + " "+
                            allVehiculos[i].AnioVehiculo+ " "+
                            allVehiculos[i].Cilindraje+ " "+
                            allVehiculos[i].Combustible
            );
        }
    }

}