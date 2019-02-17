package com.e.bbcplacementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<FruitButton> ButtonOfFriuits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void process(JSONObject obj){

        try {
            JSONArray fruitArray = obj.getJSONArray("fruit");
            for (int i = 0; i < fruitArray.length(); i++){
                Button button = new Button(this);

                JSONObject object = fruitArray.getJSONObject(i);
                Fruit fruit = new Fruit(object);
                ButtonOfFriuits.add(new FruitButton(fruit,button));
            }
        }
        catch (JSONException e){
            System.out.printf(e.getMessage());
        }
    }

    public void loadFromServer(){
        String url = "https://raw.githubusercontent.com/fmtvp/recruit-test-data/master/data.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                         process(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }


        );






    }
}
