package com.example.ca1_20325;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btnInsProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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