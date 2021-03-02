package com.cours.tp_androidstudio;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends MainActivity {


    public static void displayActivity(MainActivity activity,String avatar,String nom){
        Intent intent = new Intent(activity, com.cours.tp_androidstudio.ImageActivity.class);
        intent.putExtra("avatar",avatar);
        intent.putExtra("nom",nom);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        String avatar = getIntent().getExtras().getString("avatar","");
        String nom = getIntent().getExtras().getString("nom","");

        setTitle(nom);
        showBack();
        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(avatar).into(imageView);

    }
}