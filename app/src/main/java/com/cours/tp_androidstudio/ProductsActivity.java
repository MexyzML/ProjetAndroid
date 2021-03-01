package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProductsActivity extends MainActivity {

    ArrayList<Product> students;
    ProductAdapter studentAdapter;
    RecyclerView recyclerView;

    public static void displayActivity(HomeActivity activity) {
        Intent intent = new Intent(activity, ProductsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        setTitle("Products List");
    }



}


