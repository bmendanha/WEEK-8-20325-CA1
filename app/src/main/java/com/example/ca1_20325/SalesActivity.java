package com.example.ca1_20325;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ca1_20325.adapters.adapterBasketItem;
import com.example.ca1_20325.controller.ProductCtrl;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

import java.util.ArrayList;
import java.util.List;

public class SalesActivity extends AppCompatActivity {

    private Spinner spnProducts;
    private List<Product>productList;
    private ProductCtrl productCtrl;
    private EditText qtdItem;
    private TextView tvTotalOrder;

    //basket
    private ListView lsvBasket;
    private List<BasketItem> listbasketItems;
    private adapterBasketItem adpBasketItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        // Start spinner
        this.productCtrl = new ProductCtrl(ConnectionSQLite.getInstance(this));
        this.productList = this.productCtrl.getListProductsCtrl();

        this.spnProducts = (Spinner) this.findViewById(R.id.spnproduct);
        ArrayAdapter<Product> spnProductAdapter = new ArrayAdapter<Product>(this,
                android.R.layout.simple_spinner_item,
                this.productList
        );
        this.spnProducts.setAdapter(spnProductAdapter);
        // end spinner

        this.qtdItem = (EditText) this.findViewById(R.id.edtQtdProduct);

        this.tvTotalOrder = (TextView) this.findViewById(R.id.tvTotalOrder);

        //var and obj of basket
        this.lsvBasket = (ListView) this.findViewById(R.id.lsvProducts);
        this.listbasketItems = new ArrayList<>();
        this.adpBasketItem = new adapterBasketItem(SalesActivity.this, this.listbasketItems);
        this.lsvBasket.setAdapter(this.adpBasketItem);

        this.lsvBasket.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                final BasketItem basketItem = (BasketItem) adpBasketItem.getItem(position);
                AlertDialog.Builder windowBasket = new AlertDialog.Builder(SalesActivity.this);
                windowBasket.setTitle("Select: ");
                windowBasket.setMessage("Do you want delete the selected item?");

                windowBasket.setNegativeButton("NO", null);

                windowBasket.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean deleted = false;
                        deleted = adpBasketItem.removeItemBasket(position);

                        double totalSale = calcTotalSale(listbasketItems);
                        atuaTotalValueOrder(totalSale);

                        if (!deleted) {
                            Toast.makeText(SalesActivity.this, "ERRO do delete item from the basket", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                windowBasket.create().show();

            }
        });

    }
    public void eventAddProduct(View view){
        BasketItem basketItem = new BasketItem();

        Product SelectedProduct = (Product) this.spnProducts.getSelectedItem();
        int qtdProduct = 0;
        if (this.qtdItem.getText().toString().equals("")) {
            qtdProduct=1;
        }else {
            qtdProduct = Integer.parseInt(this.qtdItem.getText().toString());
        }

        basketItem.setName(SelectedProduct.getName());
        basketItem.setQtdSelected(qtdProduct);
        basketItem.setPriceProduct(SelectedProduct.getPrice());
        basketItem.setPriceUnit(basketItem.getPriceUnit()* basketItem.getQtdSelected());

        this.adpBasketItem.addItemBasket(basketItem);

        double totalSale = this.calcTotalSale(this.listbasketItems);
        this.atuaTotalValueOrder(totalSale);
    }

    private double calcTotalSale(List<BasketItem>pBasketItem){
        double totalSale = 0.0d;
        for (BasketItem basketItem : pBasketItem){
            totalSale += basketItem.getPriceUnit();
        }
        return totalSale;
    }

    private void atuaTotalValueOrder(double pTotalValue){
        this.tvTotalOrder.setText(String.valueOf(pTotalValue));
    }
}