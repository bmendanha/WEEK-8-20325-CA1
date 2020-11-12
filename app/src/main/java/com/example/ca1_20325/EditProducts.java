package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditProducts extends AppCompatActivity {

    private EditText edtIdProduct;
    private EditText edtNameProduct;
    private EditText edtPriceProduct;
    private EditText edtQtdProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_products);

        this.edtIdProduct = (EditText) findViewById(R.id.edtIdProduct);
        this.edtNameProduct = (EditText) findViewById(R.id.edtProductName);
        this.edtPriceProduct = (EditText) findViewById(R.id.edtPriceProduct);
        this.edtQtdProduct = (EditText) findViewById(R.id.edtQtdProduct);

        Bundle bundleDataProduct = getIntent().getExtras();
        Product product = new Product();
        product.setId(bundleDataProduct.getLong("id_product"));
        product.setName(bundleDataProduct.getString("name_product"));
        product.setPrice(bundleDataProduct.getDouble("price_product"));
        product.setQuantity(bundleDataProduct.getInt("quantity_product"));

        this.setDataProduct(product);

    }

    private void setDataProduct(Product product){
        this.edtIdProduct.setText(String.valueOf(product.getId()));
        this.edtNameProduct.setText(product.getName());
        this.edtPriceProduct.setText(String.valueOf(product.getPrice()));
        this.edtQtdProduct.setText(String.valueOf(product.getQuantity()));



    }

}