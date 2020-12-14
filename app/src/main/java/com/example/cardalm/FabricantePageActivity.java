package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FabricantePageActivity extends AppCompatActivity {

    EditText txt_idF, txt_nombreF, txt_paisF;
    BeanFabricante beanf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabricante_page);

        txt_idF = findViewById(R.id.txt_nombreUser);
        txt_nombreF = findViewById(R.id.txt_wordUser);
        txt_paisF = findViewById(R.id.txt_passwUser);

        beanf = new BeanFabricante(this);
    }

    public void addFab_OnClick(View v){
        int id_fabricante = Integer.parseInt(txt_idF.getText().toString());
        beanf.Add(
                id_fabricante,
                txt_nombreF.getText().toString(),
                txt_paisF.getText().toString()
        );
        Toast.makeText(this, "Fabricante Insertado ", Toast.LENGTH_LONG).show();
    }

    public void updateFab_Onclick(View v) {
        int id_fabricante = Integer.parseInt(txt_idF.getText().toString());
        beanf.Update(
                id_fabricante,
                txt_nombreF.getText().toString(),
                txt_paisF.getText().toString()
        );
        Toast.makeText(this, "Fabricante actualizado ", Toast.LENGTH_LONG).show();
    }

    public void deleteFab_onclick(View v) {
        int id_fabricante = Integer.parseInt(txt_idF.getText().toString());

        beanf.Delete(id_fabricante);

        txt_idF.setText("");
        txt_nombreF.setText("");
        txt_paisF.setText("");

        Toast.makeText(this, "Fabricante eliminado ", Toast.LENGTH_LONG).show();
    }

    public void selectOne_Onclick(View v) {
        int id_fabricante = Integer.parseInt(txt_idF.getText().toString());

        Fabricante fv = beanf.SelectOne(id_fabricante);
        txt_nombreF.setText(fv.NombreFabricante);
        txt_paisF.setText(fv.Pais);

        Toast.makeText(this, "Datos Recuperados" , Toast.LENGTH_LONG).show();
    }

    public void selectByPais (View v){
        Fabricante[] r = beanf.SelectByPais(txt_paisF.getText().toString());

        if (r != null) {
            // colocar primer registro en pantalla
            txt_idF.setText("" + r[0].IdFabricante);
            txt_nombreF.setText("" + r[0].NombreFabricante);
            txt_paisF.setText("" + r[0].Pais);

            Toast.makeText(this, "Se encontraron "+ r.length + " registros!" , Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No se encontraron ningun registro!" , Toast.LENGTH_LONG).show();
        }
    }



}