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

    /** The custom constructor for a fruit button
     * This creates a button and initialises it's
     * on clickListener
     * @param fruit the fruit associated with this fruit button
     * @param button the button associated with this fruit button
     */
    public FruitButton(Fruit fruit, Button button){
        this.fruit = fruit;
        this.button = button;
        button.setText(fruit.getType());

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long pageTime = System.currentTimeMillis();
                Intent intent = new Intent(getContext(), FruitPage.class);
                intent.putExtra("fruit", getFruit());
                getContext().startActivity(intent);
                pageTime = System.currentTimeMillis()- pageTime;
                String pageTimeParam = String.valueOf(pageTime);


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
        });

    }

    /** Returns the fruit associated with this button
     *
     * @return the fruit associated with this fruit button
     */
    public Fruit getFruit() {
        return this.fruit;
    }

    /** Changes the fruit associated with this button
     *
     * @param fruit The new fruit to be associated with this fruit button
     */
    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    /** Returns the button associated with this fruit button
     *
     * @return the button associated with this fruit button
     */
    public Button getButton() {
        return button;
    }

    /** Changes the button associated with this fruit button
     *
     * @param button the new button to be associated with this fruit button
     */
    public void setButton(Button button) {
        this.button = button;

    }

    /** This removes the fruit button from it's parent
     *
     */
    public void clear(){
        ViewGroup layout = (ViewGroup)this.button.getParent();
        layout.removeView(this.button);

    }

    /** Returns the coontext of this fruit button.
     *
     * @return the context of this fruit button
     */
    public Context getContext(){
        return button.getContext();
    }

    /*** Accepts a request to be processed through volley
     *
     * @param request the request to be processed through Volley
     */
    @Override
    public void request(Request request) {
        RequestQueue queue = Volley.newRequestQueue(getContext());


        queue.add(request);
    }
}
