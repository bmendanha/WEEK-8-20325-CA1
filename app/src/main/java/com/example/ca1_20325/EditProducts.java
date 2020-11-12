package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ca1_20325.controller.ProductCtrl;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

public class EditProducts extends AppCompatActivity {

    private EditText edtIdProduct;
    private EditText edtNameProduct;
    private EditText edtPriceProduct;
    private EditText edtQtdProduct;

    private Button btnSaveEdit;

    private Product product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_products);

        this.edtIdProduct = (EditText) findViewById(R.id.edtIdProduct);
        this.edtNameProduct = (EditText) findViewById(R.id.edtProductName);
        this.edtPriceProduct = (EditText) findViewById(R.id.edtPriceProduct);
        this.edtQtdProduct = (EditText) findViewById(R.id.edtQtdProduct);

        this.btnSaveEdit = (Button)findViewById(R.id.btnSaveProduct);

        Bundle bundleDataProduct = getIntent().getExtras();

        Product product = new Product();

        product.setId(bundleDataProduct.getLong("id_product"));
        product.setName(bundleDataProduct.getString("name_product"));
        product.setPrice(bundleDataProduct.getDouble("price_product"));
        product.setQuantity(bundleDataProduct.getInt("quantity_product"));

        this.setDataProduct(product);

        this.clickBtnSaveListener();

    }

    private void setDataProduct(Product product){
        this.edtIdProduct.setText(String.valueOf(product.getId()));
        this.edtNameProduct.setText(product.getName());
        this.edtPriceProduct.setText(String.valueOf(product.getPrice()));
        this.edtQtdProduct.setText(String.valueOf(product.getQuantity()));
    }

    private Product getProductForm(){

        // testing if the field is empty before get the data
        this.product = new Product();
        if (this.edtIdProduct.getText().toString().isEmpty() == false) {
            this.product.setId(Long.parseLong(this.edtIdProduct.getText().toString()));
        } else {
            return null;
        };

        if (this.edtNameProduct.getText().toString().isEmpty() == false) {
            this.product.setName(this.edtNameProduct.getText().toString());
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

    private void clickBtnSaveListener(){
        this.btnSaveEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product ProductToInsert = getProductForm();
                if (ProductToInsert !=null){
                    ProductCtrl productCtrl = new ProductCtrl(ConnectionSQLite.getInstance(EditProducts.this));
                    boolean refreshed = productCtrl.refreshProductCtrl(ProductToInsert);
                    if (refreshed=true){
                        Toast.makeText(EditProducts.this, "The product was saved!", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(EditProducts.this, "The product was NOT saved!", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(EditProducts.this,"All fields are required",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}