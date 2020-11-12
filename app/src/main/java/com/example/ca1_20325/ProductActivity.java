package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ca1_20325.controller.ProductCtrl;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

public class ProductActivity extends AppCompatActivity {
private  EditText edtIdProduct;
    private EditText edtProductName;
    private EditText edtQtdProduct;
    private EditText edtPriceProduct;

    private Button btnSaveProduct;


private Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        edtIdProduct = (EditText)findViewById(R.id.edtIdProduct);
        edtProductName = (EditText) findViewById(R.id.edtProductName);
        edtQtdProduct = (EditText) findViewById(R.id.edtQtdProduct);
        edtPriceProduct = (EditText) findViewById(R.id.edtPriceProduct);

        btnSaveProduct = (Button) findViewById(R.id.btnSaveProduct);
        this.clickBtnSaveListener();
    }

    private void clickBtnSaveListener(){
        this.btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product ProductToInsert = getProductForm();
                if (ProductToInsert !=null){
                    ProductCtrl productCtrl = new ProductCtrl(ConnectionSQLite.getInstance(ProductActivity.this));
                    long idProduct = productCtrl.saveProductCtrl(ProductToInsert);
                    if (idProduct>0){
                        Toast.makeText(ProductActivity.this, "The product was saved!", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(ProductActivity.this, "The product was NOT saved!", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(ProductActivity.this,"All fields are required",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private Product getProductForm(){

        // testing if the field is empty before get the data
        this.product = new Product();
        if (this.edtIdProduct.getText().toString().isEmpty() == false) {
            this.product.setId(Long.parseLong(this.edtIdProduct.getText().toString()));
        } else {
            return null;
        };

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