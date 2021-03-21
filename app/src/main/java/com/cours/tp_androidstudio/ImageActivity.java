package com.cours.tp_androidstudio;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends MainActivity {


    public static void displayActivity(MainActivity activity,String avatar,String nom, String prenom, String email, String groupe){
        Intent intent = new Intent(activity, com.cours.tp_androidstudio.ImageActivity.class);
        intent.putExtra("avatar",avatar);
        intent.putExtra("prenom",prenom);
        intent.putExtra("email",email);
        intent.putExtra("groupe",groupe);
        intent.putExtra("nom",nom);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        String avatar = getIntent().getExtras().getString("avatar","");
        String prenom = getIntent().getExtras().getString("prenom","");
        String email = getIntent().getExtras().getString("email","");
        String groupe = getIntent().getExtras().getString("groupe","");
        String nom = getIntent().getExtras().getString("nom","");

        setTitle(nom);
        showBack();
        TextView textView = findViewById(R.id.prenom);
        TextView textView2 = findViewById(R.id.email);
        TextView textView3 = findViewById(R.id.groupe);
        textView.setText(prenom);
        textView2.setText(email);
        textView3.setText(groupe);
        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(avatar).into(imageView);

    }
}