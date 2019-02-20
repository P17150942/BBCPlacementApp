package com.e.bbcplacementapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class FruitPage extends AppCompatActivity {
    Fruit fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView fruitName = findViewById(R.id.fruit_name);
        TextView price = findViewById(R.id.price);
        TextView weight = findViewById(R.id.weight);

        fruit = (Fruit) getIntent().getParcelableExtra("fruit");


        fruitName.setText("Fruit Type: " + fruit.getType());
        price.setText("Price: £" + (float) fruit.getPrice() / 100);
        weight.setText("Weight: " + (float) fruit.getWeight() / 1000 + "kg");


    }

}
