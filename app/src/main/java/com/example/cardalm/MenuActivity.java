package com.example.cardalm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Ocutar barra superior
        getSupportActionBar().hide();
    }

    public void FabricantePage_OnClick(View v) {
        Intent FabricanteAccount;
        FabricanteAccount = new Intent(this, FabricantePageActivity.class);
        //inicar activity
        startActivity(FabricanteAccount);

    }

    public void Register2Page_OnClick(View v) {
        Intent RegisterAccount;
        RegisterAccount = new Intent(this, RegisterActivity2.class);
        //inicar activity
        startActivity(RegisterAccount);
    }

    public void VehiculoPage_OnClick(View v) {
        Intent VehiculoAccount;
        VehiculoAccount = new Intent(this, VehiculoActivity.class);
        //inicar activity
        startActivity(VehiculoAccount);
    }



}