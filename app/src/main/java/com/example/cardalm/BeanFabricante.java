package com.example.cardalm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BeanFabricante {

    SQLiteHelperModel sqlhelper;
    SQLiteDatabase db;

    public BeanFabricante(Context ctx) {
        sqlhelper = new SQLiteHelperModel(ctx, "carAlmacenDB.db",null,1);
        db = sqlhelper.getWritableDatabase();
    }

    public void Add(int id_fabricante, String nombre_fabricante, String pais) {
        db.execSQL("INSERT INTO vh_fabricante(id_fabricante, nombre_fabricante,pais) VALUES (?,?,?)",
                new Object[] {id_fabricante,nombre_fabricante,pais} );
    }

    public void Update(int id_fabricante, String nombre_fabricante, String pais){
        db.execSQL("UPDATE vh_fabricante SET nombre_fabricante = ?, pais = ? WHERE id_fabricante = ?",
                new Object[] {nombre_fabricante, pais, id_fabricante}
        );
    }

    public void Delete (int id_fabricante){
        db.execSQL("DELETE FROM vh_fabricante WHERE id_fabricante = ?",
                new Object[] {id_fabricante} );
    }

    public Fabricante SelectOne(int id_fabricante) {
        Fabricante dta = new Fabricante();
        Cursor c = db.rawQuery("SELECT * FROM vh_fabricante WHERE id_fabricante = " + id_fabricante,
                null );
        // c.moveToFirst() -> Dice que se mueva  ala primera fila de la consulta
        if (c.moveToFirst() ) {
            dta.IdFabricante = c.getInt(0);
            dta.NombreFabricante = c.getString(1);
            dta.Pais = c.getString(2);
            return dta;
        }else {
            return null;
        }

    }

    public Fabricante[] SelectAllFab() {
        Cursor c = db.rawQuery("SELECT * FROM vh_fabricante ORDER BY nombre_fabricante ",
                null );
        if (c.getCount() > 0) {
            Fabricante [] lst = new Fabricante[c.getCount()];
            int i = 0;

            while (c.moveToNext()){
                Fabricante dta = new Fabricante();

                dta.IdFabricante = c.getInt(0);
                dta.NombreFabricante = c.getString(1);
                dta.Pais = c.getString(2);

                lst[i] = dta;
                i++;
            }
            return lst;
        } else {
            return null;
        }
    }


    public Fabricante[] SelectByPais(String pais){
        pais = "%" + pais + "%";
        Cursor c = db.rawQuery("SELECT * FROM vh_fabricante WHERE pais LIKE ? ORDER BY nombre_fabricante",
                new String[] {pais} );

        if (c.getCount() > 0) {
            Fabricante [] lst = new Fabricante[c.getCount()];
            int i = 0;

            while (c.moveToNext()){
                Fabricante dta = new Fabricante();
                dta.IdFabricante = c.getInt(0);
                dta.NombreFabricante = c.getString(1);
                dta.Pais = c.getString(2);
                lst[i] = dta;
                i++;
            }
            return lst;
        } else {
            return null;
        }
    }

    public Fabricante[] SelectByNombre(String nombre){
        nombre = "%" + nombre + "%";
        Cursor c = db.rawQuery("SELECT * FROM vh_fabricante WHERE nombre_fabricante LIKE ? ORDER BY nombre_fabricante",
                new String[] {nombre} );

        if (c.getCount() > 0) {
            Fabricante [] lst = new Fabricante[c.getCount()];
            int i = 0;

            while (c.moveToNext()){
                Fabricante dta = new Fabricante();
                dta.IdFabricante = c.getInt(0);
                dta.NombreFabricante = c.getString(1);
                dta.Pais = c.getString(2);
                lst[i] = dta;
                i++;
            }
            return lst;
        } else {
            return null;
        }
    }


    public void AddVehiculos(int idvehiculo, String marcaVehiculo, int idFabricante,
                             String modeloVehiculo, int anioVehiculo, int cilindrajeVh, String combustibleVh) {
        db.execSQL("INSERT INTO vh_vehiculo(id_vehiculo, marca,id_fabricante,modelo,anio,cilindraje,id_tipo_combustible) VALUES (?,?,?,?,?,?,?)",
                new Object[] {idvehiculo,marcaVehiculo,idFabricante,modeloVehiculo,anioVehiculo,cilindrajeVh,combustibleVh} );
    }

    public void UpdateVehiculos(int idvehiculo, String marcaVehiculo, int idFabricante,
                             String modeloVehiculo, int anioVehiculo, int cilindrajeVh, String combustibleVh) {
        db.execSQL("UPDATE vh_vehiculo SET  marca = ?,id_fabricante = ?,modelo = ?,anio = ?," +
                        "cilindraje = ?,id_tipo_combustible = ? WHERE id_vehiculo = ?",
                new Object[] {idvehiculo,marcaVehiculo,idFabricante,modeloVehiculo,anioVehiculo,cilindrajeVh,combustibleVh} );
    }

    public void DeleteVehiculo (int idvehiculo){
        db.execSQL("DELETE FROM vh_vehiculo WHERE id_vehiculo = ?",
                new Object[] {idvehiculo} );
    }

    public Vehiculo SelectOneVehiculo(int idvehiculo) {
        Vehiculo vh = new Vehiculo();
        Cursor c = db.rawQuery("SELECT * FROM vh_vehiculo WHERE id_vehiculo = " + idvehiculo,
                null );

        // c.moveToFirst() -> Dice que se mueva  ala primera fila de la consulta
        if (c.moveToFirst() ) {
            vh.IdVehiculo = c.getInt(0);
            vh.Marca = c.getString(1);
            vh.IdFabricante = c.getInt(2);
            vh.Modelo = c.getString(3);
            vh.AnioVehiculo = c.getInt(4);
            vh.Cilindraje = c.getInt(5);
            vh.Combustible = c.getString(6);

            return vh;
        }else {
            return null;
        }
    }

    public Vehiculo[] SelectAllVehiculos() {
        Cursor c = db.rawQuery("SELECT * FROM vh_vehiculo ORDER BY marca ",
                null );
        if (c.getCount() > 0) {
            Vehiculo[] vehiculoList = new Vehiculo[c.getCount()];
            int i = 0;

            while (c.moveToNext()){
                Vehiculo vh = new Vehiculo();

                vh.IdVehiculo = c.getInt(0);
                vh.Marca = c.getString(1);
                vh.IdFabricante = c.getInt(2);
                vh.Modelo = c.getString(3);
                vh.AnioVehiculo = c.getInt(4);
                vh.Cilindraje = c.getInt(5);
                vh.Combustible = c.getString(6);

                vehiculoList[i] = vh;
                i++;
            }
            return vehiculoList;
        } else {
            return null;
        }
    }

}
