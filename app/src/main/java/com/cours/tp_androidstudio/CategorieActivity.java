package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class CategorieActivity extends MainActivity  {

    public static void displayActivity(HomeActivity activity) {
        Intent intent = new Intent(activity, CategorieActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        setTitle("Categories");
        showBack();


    }

}
