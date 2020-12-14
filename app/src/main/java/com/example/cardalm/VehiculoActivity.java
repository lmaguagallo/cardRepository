package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VehiculoActivity extends AppCompatActivity {

    EditText txt_idVehiculo,txt_idFab,txt_marca,txt_modelo,txt_anio,txt_cilin,txt_comb;
    //Adminstracion de Datos
    BeanFabricante beanf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehiculo);

        //Ocutar barra superior
        getSupportActionBar().hide();
        //inicalizar EditText
        txt_idVehiculo = findViewById(R.id.txt_idVehiculo);
        txt_idFab = findViewById(R.id.txt_idFab);
        txt_marca = findViewById(R.id.txt_marca);
        txt_modelo = findViewById(R.id.txt_modelo);
        txt_anio = findViewById(R.id.txt_anio);
        txt_cilin = findViewById(R.id.txt_cilin);
        txt_comb = findViewById(R.id.txt_comb);
        // Iniciar BeanUser
        beanf = new BeanFabricante(this);


    }

    public void addVehiculo_OnClick(View v) {
        // Conversion de tipos
        int idVehiculo = Integer.parseInt(txt_idVehiculo.getText().toString());
        String marcaVehiculo = txt_marca.getText().toString();
        int idFabricante = Integer.parseInt(txt_idFab.getText().toString());
        String modeloVehiculo = txt_modelo.getText().toString();
        int anioVehiculo = Integer.parseInt(txt_anio.getText().toString());
        int cilindrajeVehi = Integer.parseInt(txt_cilin.getText().toString());
        String combustibleVehi = txt_comb.getText().toString();

        if (!(txt_idVehiculo.getText().toString()).equals("")  && !marcaVehiculo.equals("") &&
                !(txt_idFab.getText().toString()).equals("") &&
                !modeloVehiculo.equals("") && !txt_anio.getText().toString().equals("") &&
                !txt_cilin.getText().toString().equals("") && !combustibleVehi.equals("")
        ){
            beanf.AddVehiculos(
                    idVehiculo,marcaVehiculo,idFabricante,
                    modeloVehiculo,anioVehiculo,
                    cilindrajeVehi,combustibleVehi
            );
            Toast.makeText(this, "Vehiculo Insertado ", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Capos vacios ", Toast.LENGTH_LONG).show();
        }

    }

    public void updateVehiculo_OnClick(View v) {
        // Conversion de tipos
        int idVehiculo = Integer.parseInt(txt_idVehiculo.getText().toString());
        String marcaVehiculo = txt_marca.getText().toString();
        int idFabricante = Integer.parseInt(txt_idFab.getText().toString());
        String modeloVehiculo = txt_modelo.getText().toString();
        int anioVehiculo = Integer.parseInt(txt_anio.getText().toString());
        int cilindrajeVehi = Integer.parseInt(txt_cilin.getText().toString());
        String combustibleVehi = txt_comb.getText().toString();

        if (!txt_idVehiculo.getText().toString().equals("")){
            beanf.UpdateVehiculos(
                    idVehiculo,marcaVehiculo,idFabricante,
                    modeloVehiculo,anioVehiculo,
                    cilindrajeVehi,combustibleVehi
            );
            Toast.makeText(this, "Vehiculo Actualizado ", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Capos vacios ", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteVeehiculo_onclick(View v) {

        if (!txt_idVehiculo.getText().toString().equals("")){
            // Conversion de tipos
            int idVehiculo = Integer.parseInt(txt_idVehiculo.getText().toString());
            beanf.DeleteVehiculo(idVehiculo);
            Toast.makeText(this, "Vehiculo Eliminado ", Toast.LENGTH_LONG).show();
            //asiganr informacion
            txt_idVehiculo.setText("");
            txt_idFab.setText("");
            txt_marca.setText("");
            txt_modelo.setText("");
            txt_anio.setText("");
            txt_cilin.setText("");
            txt_comb.setText("");
        }else{
            Toast.makeText(this, "Campo de Id Vehiculo vacio! ", Toast.LENGTH_LONG).show();
        }
    }

    public void selectOneVehiculo_Onclick(View v) {
        if (!txt_idVehiculo.getText().toString().equals("")){
            // Conversion de tipos
            int idVehiculo = Integer.parseInt(txt_idVehiculo.getText().toString());

            Vehiculo vh = beanf.SelectOneVehiculo(idVehiculo);

            if (vh != null){
                //asiganr informacion
                //txt_idVehiculo.setText(vh.IdVehiculo);
                txt_idFab.setText(vh.IdFabricante+"");
                txt_marca.setText(vh.Marca);
                txt_modelo.setText(vh.Modelo);
                txt_anio.setText(vh.AnioVehiculo+"");
                txt_cilin.setText(vh.Cilindraje+"");
                txt_comb.setText(vh.Combustible);
                Toast.makeText(this, "Hecho" , Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "No se encontro datos!" , Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this, "Campo de Id Vehiculo vacio!" , Toast.LENGTH_LONG).show();
        }
    }

}