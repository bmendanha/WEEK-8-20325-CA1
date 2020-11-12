package com.example.ca1_20325.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ca1_20325.Product;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

import java.util.ArrayList;
import java.util.List;

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
            values.put("name", pProduct.getName());
            values.put("quantity", pProduct.getQuantity());
            values.put("price", pProduct.getPrice());

            long idProductInserted = db.insert("product", null, values);
            return idProductInserted;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return 0;
    }

    public List<Product> getListProductDAO() {
        List<Product> productList = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM product;";
        try {
            db = this.connectionSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                Product productTemp = null;
                do {
                    productTemp = new Product();
                    productTemp.setId(cursor.getLong(0));
                    productTemp.setName(cursor.getString(1));
                    productTemp.setQuantity(cursor.getInt(2));
                    productTemp.setPrice(cursor.getDouble(3));

                    productList.add(productTemp);

                } while (cursor.moveToNext());
            }

        }catch(Exception e){
            Log.d("ERROR", "ERROR to return the products");
        } finally{
                if (db != null) {
                    db.close();
                }
        }
        return productList;
    }

}