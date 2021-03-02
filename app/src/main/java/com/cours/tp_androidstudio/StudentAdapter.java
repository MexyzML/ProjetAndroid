package com.cours.tp_androidstudio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student=students.get(position);
        holder.getTextViewName().setText(student.getNom());
        Picasso.get().load(student.getAvatar()).into(holder.getAvatarViewStudent());
        holder.getLayoutCell().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ImageActivity.displayActivity(activity,student.getAvatar(),student.getNom());
            }
        });
    }
    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNom;
       // private final TextView textViewEmail;
        private final ImageView avatarViewStudent;
        private final View layoutCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewNom = view.findViewById(R.id.textViewNom);
        //    textViewEmail = view.findViewById(R.id.textViewEmail);
            avatarViewStudent =  view.findViewById(R.id.avatarViewStudent);
            layoutCell = view.findViewById(R.id.layoutCell);
        }

        public TextView getTextViewName() {
            return textViewNom;
        }
        public View getLayoutCell() {
            return layoutCell;
        }

        public ImageView getAvatarViewStudent() {
            return avatarViewStudent;
        }
    }
}
