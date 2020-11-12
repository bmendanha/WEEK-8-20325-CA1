package com.example.ca1_20325.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionSQLite extends SQLiteOpenHelper {


    //this is a standard constructor for the database
    private static  ConnectionSQLite INSTANCIA_CONEXAO;
    private static final int VERSAO_DB =1;
    private static final String NOME_DB = "ca1_products_app";

    public ConnectionSQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }
    // Enf of the constructor for the database


    //When calling this method, a test will be done to see if my instance is already null.
    // If it is null it will be instantaneous otherwise it will be returned to what already exists.
    public static  ConnectionSQLite getInstance(Context context){
        if (INSTANCIA_CONEXAO == null){
            INSTANCIA_CONEXAO = new ConnectionSQLite(context);

        }
        return INSTANCIA_CONEXAO;
        }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String sqlProductTable =
        "CREATE TABLE IF NOT EXISTS product" +
                "(" +
                "id INTEGER PRIMARY KEY,"+
                "name TEXT," +
                "quantity INTEGER,"+
                "price REAL" +
                ")";
    sqLiteDatabase.execSQL(sqlProductTable);

    String sqlTableSales=
        "CREATE TABLE IF NOT EXISTS sales" +
                "(" +
                "id INTEGER PRIMARY KEY," +
                "data INTEGER"+
                ")";
        sqLiteDatabase.execSQL(sqlTableSales);

     String sqlTableOrder=
          "CREATE TABLE IF NOT EXISTS orders" +
                  "(" +
                  "id INTEGER PRIMARY KEY," +
                  "quantity INTEGER,"+
                  "id_product INTEGER,"+
                  "id_sales INTEGER"+
                  ")";
        sqLiteDatabase.execSQL(sqlTableOrder);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
