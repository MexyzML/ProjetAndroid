package com.cours.tp_androidstudio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    private ArrayList<Student> students;
    private MainActivity activity;

    public StudentAdapter(MainActivity activity, ArrayList<Student> students){
        this.activity=activity;
        this.students=students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
       // private final TextView textViewEmail;
       // private final ImageView avatarViewStudent;
        private final View layoutCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewName = view.findViewById(R.id.textViewName);
        //    textViewEmail = view.findViewById(R.id.textViewEmail);
        //    avatarViewStudent =  view.findViewById(R.id.imageViewStudent);
          layoutCell = view.findViewById(R.id.layoutCell);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getLayoutCell() {
            return textViewName;
        }
    }
}
