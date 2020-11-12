//CA1 12/11/2020 - Mobile App 2 - BSC30920
// ID: 20325 - Bruno H.M. Mendanha

package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ca1_20325.controller.ProductCtrl;
import com.example.ca1_20325.dbHelper.ConnectionSQLite;

public class MainActivity extends AppCompatActivity {

    private Button btnInsProduct;
    private Button btnListProduct;
    private Button btnOrderProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling the created SQLite connection
        ConnectionSQLite connectionSQLite = ConnectionSQLite.getInstance(this);

        //I kept the part bellow just to show a small test that I have done

        //Forced Product here
        //1. Darjelling : 8.50 per 100 gram bag
        //2. Assam : 7.50 per 100 gram bag
        //3. Lapsang : Sous 9.5 per 100 gram bag
        //4. Earl Grey:  3.5 per 100 gram bag
        //5. Irish Breakfast : 2.5 per 100 gram bag


    /*    Product product1 = new Product();
        product1.setId(1);
        product1.setName("Darjelling");
        product1.setQuantity(1000);
        product1.setPrice(8.50);

        ProductCtrl productCtrl = new ProductCtrl(connectionSQLite);
        long result1 = productCtrl.saveProductCtrl(product1);
        System.out.println("RESULTADO: "+ result1);


        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Assam");
        product2.setQuantity(1000);
        product2.setPrice(7.50);

        long result2 = productCtrl.saveProductCtrl(product2);
        System.out.println("RESULTADO: "+ result2);


        Product product3 = new Product();
        product3.setId(3);
        product3.setName("Lapsang");
        product3.setQuantity(1000);
        product3.setPrice(9.50);

        long result3 = productCtrl.saveProductCtrl(product3);
        System.out.println("RESULTADO: "+ result3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("Earl Grey");
        product4.setQuantity(1000);
        product4.setPrice(3.50);
        long result4 = productCtrl.saveProductCtrl(product4);
        System.out.println("RESULTADO: "+ result4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setName("Irish Breakfast");
        product5.setQuantity(1000);
        product5.setPrice(2.50);
        long result5 = productCtrl.saveProductCtrl(product5);
        System.out.println("RESULTADO: "+ result5);

*/

        this.btnInsProduct = (Button) findViewById(R.id.btnInsProduct);
        this.btnListProduct = (Button) findViewById(R.id.btnListProduct);
        this.btnOrderProduct = (Button) findViewById(R.id.btnOrderProduct);


        this.btnInsProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when click on the button "Insert Product" will be executed the commands bellow
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        this.btnListProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListProducts.class);
                startActivity(intent);
            }
        });

        this.btnOrderProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SalesActivity.class);
                startActivity(intent);
            }
        });
    }
}