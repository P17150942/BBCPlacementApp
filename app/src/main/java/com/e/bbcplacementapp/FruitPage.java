package com.e.bbcplacementapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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

        //loads the fruit fruit information on the page. Converts to suitable units
        fruitName.setText("Fruit Type: " + fruit.getType());
        price.setText("Price: £" + (float) fruit.getPrice() / 100);
        weight.setText("Weight: " + (float) fruit.getWeight() / 1000 + "kg");


    }


    @Override
    public void onBackPressed() {

        long pageTime = System.currentTimeMillis();
        //close page
        finish();
        pageTime = System.currentTimeMillis()- pageTime;
        //sets the calculated time as a strig
        String pageTimeParam = String.valueOf(pageTime);

        // creates then processes a fire and forget request
        StringRequest fire = new StringRequest(Request.Method.GET,
                "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/stats?event=load&data=" + String.valueOf(pageTime),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                    }
                },
                null

        );
        request(fire);

    }

    public void request(Request request){

        RequestQueue queue = Volley.newRequestQueue(this);


        queue.add(request);

    }

}
