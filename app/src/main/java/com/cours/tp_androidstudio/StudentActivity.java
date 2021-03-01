package com.cours.tp_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class StudentActivity extends MainActivity  {

    public static void displayActivity(GroupActivity activity) {
        Intent intent = new Intent(activity, StudentActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        setTitle("Infos");


    }
}
