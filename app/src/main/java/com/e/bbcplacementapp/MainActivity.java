package com.e.bbcplacementapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FruitButtonRegister fruitButtonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        fruitButtonRegister = new FruitButtonRegister((LinearLayout)findViewById(R.id.fruit_button_holder));

        request(

                new JsonObjectRequest(Request.Method.GET, "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/data.json", null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                processJson(response);
                            }
                        },null)


        );

        // creates a button that when pressed can retrive information from the server
        Button serverButton = findViewById(R.id.reload_server);
        serverButton.setText("Reload");
        serverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruitButtonRegister.clear();
                request(

                        new JsonObjectRequest(Request.Method.GET, "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/data.json", null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        long reqTime = System.currentTimeMillis();
                                        processJson(response);
                                        reqTime = System.currentTimeMillis() - reqTime;

                                        // sends another fire and forget request through Volley when reloading from the server
                                        request(new StringRequest(Request.Method.GET,
                                                "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/stats?event=load&data=" + String.valueOf(reqTime),
                                                new Response.Listener<String>() {
                                                    @Override
                                                    public void onResponse(String response) {

                                                    }
                                                },
                                                null

                                        ));



                                    }
                                },null)

                );
            }
        });

    }



    public void processJson(JSONObject obj){


        try{

            JSONArray fruitArray = obj.getJSONArray("fruit");
            for (int i = 0; i < fruitArray.length(); i++){
                Fruit fruit = new Fruit(obj.getJSONArray("fruit").getJSONObject(i));

                Button button = new Button(this);


                fruitButtonRegister.add(new FruitButton(fruit, button));
            }

        }catch(JSONException e){
            Log.d("WhatIsThisThing", e.getMessage());
        }
    }

    public void request(Request request){

        RequestQueue queue = Volley.newRequestQueue(this);


        queue.add(request);

    }
}
