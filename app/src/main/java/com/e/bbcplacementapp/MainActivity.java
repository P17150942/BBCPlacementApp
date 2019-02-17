package com.e.bbcplacementapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<FruitButton> fruitButtonRegister;
    LinearLayout fruitButtonHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitButtonRegister = new ArrayList<FruitButton>();

        fruitButtonHolder = findViewById(R.id.fruit_button_holder);
        fruitButtonHolder.setOrientation(LinearLayout.VERTICAL);
        loadFromServer();



    }


    public void changeActivity(){
        startActivity(new Intent(this, FruitPage.class));
    }
    public void process(JSONObject obj){

        try{
            JSONArray fruitArray = obj.getJSONArray("fruit");
            for (int i = 0; i < fruitArray.length(); i++){
                Button button = new Button(this);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeActivity();
                    }
                });
                Fruit fruit = new Fruit(obj.getJSONArray("fruit").getJSONObject(i));

                button.setText(fruit.getType());
                button.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                fruitButtonHolder.addView(button);
                fruitButtonRegister.add(new FruitButton(fruit,button));
            }

        }catch(JSONException e){

        }





    }

    public void loadFromServer(){

        String url = "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/data.json";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        process(response);
                    }
                },null);
        queue.add(jsonReq);

    }
}
