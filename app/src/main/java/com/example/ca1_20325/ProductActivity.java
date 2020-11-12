package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProductActivity extends AppCompatActivity {

    private EditText edtProductName;
    private EditText edtQtdProduct;
    private EditText edtPriceProduct;
    private Button btnSaveProduct;

private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        edtProductName = (EditText) findViewById(R.id.edtProductName);
        edtQtdProduct = (EditText) findViewById(R.id.edtQtdProduct);
        edtPriceProduct = (EditText) findViewById(R.id.edtPriceProduct);

        btnSaveProduct = (Button) findViewById(R.id.btnSaveProduct);


    }

    private Product getProductForm(){

        // testing if the field is empty before get the data
        this.product = new Product();
        if (this.edtProductName.getText().toString().isEmpty() == false) {
            this.product.setName(this.edtProductName.getText().toString());
        } else {
            return null;
        };

        if (edtQtdProduct.getText().toString().isEmpty() == false) {
            int qtdProduct = Integer.parseInt(this.edtQtdProduct.getText().toString());
            this.product.setQuantity(qtdProduct);
        } else {
            return null;
        };

        if (edtPriceProduct.getText().toString().isEmpty() == false) {
            double priceProduct = Double.parseDouble(this.edtPriceProduct.getText().toString());
            this.product.setPrice(priceProduct);
        } else {
            return null;
        };

        return product;

    }


}