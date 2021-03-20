package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CategorieActivity extends MainActivity  {

    public static void displayActivity(HomeActivity activity) {
        Intent intent = new Intent(activity, CategorieActivity.class);
        activity.startActivity(intent);
    }
    private ArrayList<Categorie> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        setTitle("Categories");
        showBack();
        categories=new ArrayList<>();
        RecyclerView recyclerView=findViewById(R.id.recyclerViewCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategorieAdapter categorieAdapter=new CategorieAdapter(this,categories);
        recyclerView.setAdapter(categorieAdapter);

        String url = "http://djemam.com/epsi/categories.json";
        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject= new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for(int i=0;i<jsonArray.length();i++){
                        Categorie categorie=new Categorie(jsonArray.getJSONObject(i));
                        categories.add(categorie);
                    }
                    categorieAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(CategorieActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}
