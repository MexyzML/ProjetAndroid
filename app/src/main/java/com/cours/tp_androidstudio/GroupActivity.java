package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class GroupActivity extends MainActivity implements View.OnClickListener {

    ArrayList<Student> students;
    StudentAdapter studentAdapter;
    RecyclerView recyclerView;

    public static void displayActivity(HomeActivity activity) {
        Intent intent = new Intent(activity, GroupActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        setTitle("Infos");

        findViewById(R.id.buttonEtudiant1).setOnClickListener(this);
        findViewById(R.id.buttonEtudiant2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonEtudiant1:
                StudentActivity.displayActivity(this);
                break;
           // case R.id.buttonEtudiant2:
             //   Student2Activity.displayActivity(this);
               // break;
        }
    }
}


