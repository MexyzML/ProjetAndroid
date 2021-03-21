package com.cours.tp_androidstudio;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductPageActivity extends MainActivity {


    public static void displayActivity(MainActivity activity,String picture,String nom, String description){
        Intent intent = new Intent(activity, ProductPageActivity.class);
        intent.putExtra("picture_url",picture);
        intent.putExtra("name",nom);
        intent.putExtra("description",description);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageproduit);
        String picture = getIntent().getExtras().getString("picture_url","");
        String nom = getIntent().getExtras().getString("name","");
        String description = getIntent().getExtras().getString("description","");

        setTitle(nom);
        showBack();
        TextView textView = findViewById(R.id.description);
        textView.setText(description);
        ImageView imageView = findViewById(R.id.picture_url);
        Picasso.get().load(picture).into(imageView);

    }
}