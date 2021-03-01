package com.cours.tp_androidstudio;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setTitle(String title){
        TextView textView=findViewById(R.id.textViewTitle);
        if(textView !=null)
            textView.setText(title);
    }

    public void showBack(){
        ImageView imageView=findViewById(R.id.imageRetour);
        if(imageView!=null) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

    }
    @Override
    public void finish() {
        super.finish();
    }
}
