package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class GroupActivity extends MainActivity {



    public static void displayActivity(MainActivity activity) {
        Intent intent = new Intent(activity, GroupActivity.class);
        activity.startActivity(intent);
    }
    private ArrayList<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        setTitle("Infos");
        showBack();
        students = new ArrayList<>();
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        StudentAdapter studentAdapter=new StudentAdapter(this,students);
        recyclerView.setAdapter(studentAdapter);

        try {

            JSONObject jsonObject=new JSONObject(Data.allData);
            JSONArray jsonItems=jsonObject.getJSONArray("items");
            for (int i=0;i<jsonItems.length();i++){
                Student student=new Student(jsonItems.getJSONObject(i));
                students.add(student);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    }



