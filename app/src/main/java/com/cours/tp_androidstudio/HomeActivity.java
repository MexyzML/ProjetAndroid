package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends MainActivity implements View.OnClickListener {

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity,HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Acceuil");

        }

    @Override
    public void onClick(View v) {

    }
}


