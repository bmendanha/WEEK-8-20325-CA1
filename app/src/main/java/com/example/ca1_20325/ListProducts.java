package com.example.ca1_20325;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.EasyEditSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ca1_20325.adapters.adapterListProducts;
import com.example.ca1_20325.controller.ProductCtrl;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

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
        ProductCtrl productCtrl = new ProductCtrl(ConnectionSQLite.getInstance(ListProducts.this));
        productList = productCtrl.getListProductsCtrl();

        this.lsvProduct = (ListView) findViewById(R.id.lsvProducts);

        this.adapterListProduct = new adapterListProducts (ListProducts.this, this.productList);

        this.lsvProduct.setAdapter(this.adapterListProduct);

        this.lsvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Product selectedProduct = (Product) adapterListProduct.getItem(position);
                AlertDialog.Builder windowChoose = new AlertDialog.Builder(ListProducts.this);
                windowChoose.setTitle("Select: ");
                windowChoose.setMessage("What do you want to do?");
                windowChoose.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        dialogInterface.cancel();
                    }
                });

                windowChoose.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        boolean deleted = productCtrl.deleteProductCtrl(selectedProduct.getId());
                        dialogInterface.cancel();

                        if (deleted ==true){
                            adapterListProduct.removeProduct(position);
                            Toast.makeText(ListProducts.this, "Product deleted!", Toast.LENGTH_LONG);
                        }else {
                            Toast.makeText(ListProducts.this, "Product NOT deleted!", Toast.LENGTH_LONG);
                        }
                    }
                });

                windowChoose.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                   Bundle bundleDataProduct = new Bundle();

                   bundleDataProduct.putLong("id_product",selectedProduct.getId());
                   bundleDataProduct.putString("name_product",selectedProduct.getName());
                   bundleDataProduct.putDouble("price_product",selectedProduct.getPrice());
                   bundleDataProduct.putInt("quantity_product",selectedProduct.getQuantity());

                   Intent intentEditProducts = new Intent(ListProducts.this, EditProducts.class);
                   intentEditProducts.putExtras(bundleDataProduct);
                   startActivity(intentEditProducts);

                    }
                });

                windowChoose.create().show();

            }
        });
    }
}