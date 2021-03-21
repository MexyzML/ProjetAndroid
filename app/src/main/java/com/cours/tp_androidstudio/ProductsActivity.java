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


public class ProductsActivity extends MainActivity {

     ArrayList<Product>  products=new ArrayList<>();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        setTitle("Products List");

        RecyclerView recyclerView=findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductAdapter productAdapter=new ProductAdapter(this,products);
        recyclerView.setAdapter(productAdapter);

        String url = "http://djemam.com/epsi/categories.json";
        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result){
                try {
                    JSONObject jsonObject= new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for(int i=0;i<jsonArray.length();i++){
                        Product product=new Product(jsonArray.getJSONObject(i));
                        products.add(product);
                    }
                    productAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ProductsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }

}


