//CA1 12/11/2020 - Mobile App 2 - BSC30920
// ID: 20325 - Bruno H.M. Mendanha

package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ca1_20325.dbHelper.ConnectionSQLite;

public class MainActivity extends AppCompatActivity {
private Button btnInsProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling the created SQLite connection
        ConnectionSQLite connectionSQLite = ConnectionSQLite.getInstance(this);

        this.btnInsProduct = (Button) findViewById(R.id.btnInsProduct);

        this.btnInsProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when click on the button "Insert Product" will be executed the commands bellow
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });
    }
}