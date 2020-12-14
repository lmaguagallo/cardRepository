package com.example.cardalm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BeanUser {

    SQLiteHelperModel sqlhelper;
    SQLiteDatabase db;

    public BeanUser(Context ctx) {
        sqlhelper = new SQLiteHelperModel(ctx, "carAlmacenDB.db",null,1);
        db = sqlhelper.getWritableDatabase();
    }

    /**
     * Datos de Tabla vh_usuario
     */
    // User table name
    private static final String TABLE_USER = "vh_usuario";
    // User Table Columns names
    private static final String COLUMN_USER_ID = "id_user";
    private static final String COLUMN_USER_NAME = "nombre_user";
    private static final String COLUMN_USER_WORD = "word_user";
    private static final String COLUMN_USER_PASSWORD = "passw_user";

    public void AddUser(String nombre, String userr, String pssw) {
        db.execSQL("INSERT INTO vh_usuario(nombre_user,word_user,passw_user) VALUES (?,?,?)",
                new Object[] {nombre,userr,pssw} );
    }

    /**
     * Método para insertar un usuario
     * @param user
     */
    public void addUsers(Usuario user) {
        System.out.println("ok2");
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getNombre());
        values.put(COLUMN_USER_WORD, user.getUsuario());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * Este método para verificar que el usuario existe o no
     * @param user_word
     * @return true/false
     */
    public boolean checkUsuario(String user_word) {
        // matriz de columnas para recuperar
        String [] columns = {
                COLUMN_USER_ID
        };

        // criterio de selecion
        String selection = COLUMN_USER_WORD + " = ?";
        // argumento de seleccion
        String[] selectionArgs = {user_word};

        // query user table with condition
        /**
         * Aquí la función de consulta se usa para obtener registros de la tabla de usuario,
         * esta función funciona como usamos la consulta SQL.
         * Consulta SQL  equivalente a la funacion de esta consulta
         * SELECT id_user FROM vh_usuario WHERE nombre_user = 'lmmoyses';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    /**
     * Este método para actualizar el registro de usuario
     * @param user
     */
    public void updateUsuario (Usuario user){

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getNombre());
        values.put(COLUMN_USER_WORD, user.getUsuario());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * Este método es para eliminar el registro de usuario
     * @param user
     */
    public void deleteUsuario(Usuario user) {
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * Método para traer los datos de un usuario
     * @param user_word
     * @return
     */
    public Usuario[] selectByUserWord(String user_word){
        user_word = "%" + user_word + "%";
        Cursor c = db.rawQuery(
                "SELECT * FROM " + TABLE_USER + " WHERE "+ COLUMN_USER_WORD +" LIKE ? ORDER BY " + COLUMN_USER_NAME,
                new String[] {user_word}
        );

        if (c.getCount() > 0) {
            Usuario [] userList =  new Usuario[c.getCount()];
            int i = 0;

            while (c.moveToNext()) {
                Usuario u = new Usuario();
                u.Id = c.getInt(0);
                u.Nombre = c.getString(1);
                u.Usuario = c.getString(2);
                u.Password = c.getString(3);
                userList[i] = u;
                i++;
            }
            return userList;
        } else {
            return null;
        }
    }

    /**
     * Método para traer los registros de un usuario
     * @param user_word
     * @return
     */
    public Usuario selectOneUser(String user_word) {
        Usuario user = new Usuario();
        Cursor c = db.rawQuery(
                "SELECT * FROM vh_usuario WHERE word_user = ?",
                new String[] {user_word}
        );
        if(c.moveToFirst()){
            user.Id = c.getInt(0);
            user.Nombre = c.getString(1);
            user.Usuario = c.getString(2);
            user.Password = c.getString(3);
            return user;
        }else {
            return null;
        }
    }




    /**
     * Este método para verificar que el usuario existe o no
     * @param user_word
     * @param password
     * @return true/false
     */
    public boolean checkUsuario(String user_word, String password) {

        // matriz de columnas para recuperar
        String [] columns = {
                COLUMN_USER_ID
        };

        // criterio de selecion
        String selection = COLUMN_USER_WORD + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
        // argumento de seleccion
        String[] selectionArgs = {user_word, password};

        // query user table with conditions
        /**
         * Aquí la función de consulta se usa para obtener registros de la tabla de usuario,
         * esta función funciona como usamos la consulta SQL.
         * Consulta SQL  equivalente a la funacion de esta consulta
         * SELECT id_user FROM vh_usuario WHERE nombre_user = 'lmmoyses' AND passw_user = 'redcard';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

}
