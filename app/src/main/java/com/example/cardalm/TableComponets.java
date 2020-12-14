package com.example.cardalm;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class TableComponets {

    private TableLayout tableLayout; //tableLayout
    private Context context;
    private String[] headers;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView dataCelda;
    private int indexColumn;
    private int indexRow;
    private boolean multiColor = false;
    private int colorOne;
    private int colorTwo;


    /**
     * Contructor
     * @param tableLayout
     * @param context
     */
    public TableComponets(TableLayout tableLayout, Context context) {
        this.tableLayout = tableLayout;
        this.context = context;
    }

    public void AddTableTitle(String[] headers){
        this.headers = headers;
        createTableHeader();
    }

    // data de base de datos
    public void addData(ArrayList<String[]> data){
        this.data = data;
        CreateDataTable();
    }

    private void newRow(){
        tableRow = new TableRow(context);
    }

    private void newCelda(){
        dataCelda = new TextView(context);
        dataCelda.setGravity(Gravity.CENTER);
        dataCelda.setTextSize(20);
    }

    private void createTableHeader(){
        indexColumn = 0;
        newRow();
        while(indexColumn < headers.length){
            newCelda();
            dataCelda.setText(headers[indexColumn++]);
            tableRow.addView(dataCelda, newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    /**
     * Método para crear filas y llenar de informacion
     */
    private void CreateDataTable(){
        String info;

        // Creacion de Filas
        for(indexRow = 1; indexRow <= data.size() ; indexRow++){
            newRow();
            //Creacion celdas
            for(indexColumn = 0; indexColumn < headers.length; indexColumn++){
                newCelda();
                /**
                 * Aqui extraemos el array y recorremos para poner en la celda
                 * la informacion
                 */
                String[] i = data.get(indexRow-1);
                info = (indexColumn < i.length) ? i[indexColumn]:"";
                dataCelda.setText(info);
                tableRow.addView(dataCelda, newTableRowParams());
            }
            tableLayout.addView(tableRow);
        }
    }


    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params =  new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight = 1;
        return params;
    }

    /**
     * Dar color a los titulos de las columnas
     * @param color
     */
    public void backgroundHeader(int color){
        indexColumn = 0;
        while(indexColumn < headers.length){
            dataCelda = getCell(0,indexColumn++);
            dataCelda.setBackgroundColor(color);
        }
    }

    public void backgroundData(int colorOne, int colorTwo){
        for(indexRow = 1; indexRow <= headers.length ; indexRow++){
            multiColor =! multiColor;
            for(indexColumn = 0; indexColumn < headers.length; indexColumn++){
                dataCelda = getCell(indexRow,indexColumn);
                dataCelda.setBackgroundColor((multiColor)?colorOne:colorTwo);
            }
            tableLayout.addView(tableRow);
        }
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
    }

    public void recolorBackgroundData(){
        indexColumn = 0;
        while(indexColumn < headers.length){
            dataCelda = getCell(data.size() - 1,indexColumn++);
            dataCelda.setBackgroundColor((multiColor)?colorOne:colorTwo);
        }
    }


    /**
     * Buscar un Fila
     * @param index
     * @return Numero Fila
     */
    private TableRow getRow(int index){
        return((TableRow) tableLayout.getChildAt(index));
    }

    /**
     * Devuelce la celda especifica de una comumna
     * @param rowIndex
     * @param colmIndex
     * @return
     */
    public TextView getCell(int rowIndex, int colmIndex){
        tableRow = getRow(rowIndex);
        return (TextView) tableRow.getChildAt(colmIndex);
    }



}
