package com.e.bbcplacementapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.android.volley.*;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class FruitButton implements MakesRequest{
    private Fruit fruit;
    private Button button;

    public FruitButton(Fruit fruit, Button button){
        this.fruit = fruit;
        this.button = button;
        button.setText(fruit.getType());

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FruitPage.class);

                intent.putExtra("fruit", getFruit());

                getContext().startActivity(intent);
            }
        });

    }

    public Fruit getFruit() {
        return this.fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public void clear(){
        ViewGroup layout = (ViewGroup)this.button.getParent();
        layout.removeView(this.button);

    }

    public Context getContext(){
        return button.getContext();
    }


    @Override
    public void request(Request request) {
        RequestQueue queue = Volley.newRequestQueue(getContext());


        queue.add(request);
    }
}
