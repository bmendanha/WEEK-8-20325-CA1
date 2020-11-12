package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.ca1_20325.adapters.adapterListProducts;

import java.util.ArrayList;
import java.util.List;

public class ListProducts extends AppCompatActivity {

    private ListView lsvProduct;
    private List<Product> productList;
    private adapterListProducts adapterListProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);

        //Search products in database
        this.productList = new ArrayList<>();

        this.lsvProduct = (ListView) findViewById(R.id.lsvProducts);

        this.adapterListProduct = new adapterListProducts (ListProducts.this, this.productList) {
        };
        this.lsvProduct.setAdapter(this.adapterListProduct);
    }
}