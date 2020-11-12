package com.example.ca1_20325.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.ca1_20325.Product;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

public class ProductDAO {
    private final ConnectionSQLite connectionSQLite;

    public ProductDAO(ConnectionSQLite connectionSQLite) {
        this.connectionSQLite = connectionSQLite;
    }

    public long saveProductDAO(Product pProduct) {
        SQLiteDatabase db = connectionSQLite.getWritableDatabase(); // opening the database
        try {
            ContentValues values = new ContentValues();
            values.put("id", pProduct.getId());
            values.put("name",pProduct.getName());
            values.put("quantity", pProduct.getQuantity());
            values.put("price", pProduct.getPrice());

            long idProductInserted = db.insert("product", null, values);
            return idProductInserted;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
