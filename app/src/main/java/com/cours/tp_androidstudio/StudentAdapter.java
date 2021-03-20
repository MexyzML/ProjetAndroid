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
    private MainActivity activity;
    private ArrayList<Student> students;


    public StudentAdapter(MainActivity activity, ArrayList<Student> students){
        this.activity=activity;
        this.students=students;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewNom;
        private final TextView textViewPrenom;
        private final TextView textViewEmail;
        private final TextView textViewGroupe;
        private final ImageView avatarViewStudent;
        private final View layoutCell;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textViewNom = view.findViewById(R.id.textViewNom);
            textViewEmail = view.findViewById(R.id.textViewEmail);
            textViewPrenom = view.findViewById(R.id.textViewPrenom);
            avatarViewStudent =  view.findViewById(R.id.avatarViewStudent);
            textViewGroupe = view.findViewById(R.id.textViewGroupe);
            layoutCell = view.findViewById(R.id.layoutCell);
        }

        public TextView getTextViewNom() { return textViewNom; }
        public View getLayoutCell() {
            return layoutCell;
        }
        public TextView getTextViewPrenom() { return textViewPrenom; }
        public TextView getTextViewEmail() { return textViewEmail; }
        public TextView getTextViewGroupe() { return textViewGroupe; }

        public ImageView getAvatarViewStudent() {
            return avatarViewStudent;
        }

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_student, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Student student=students.get(position);
        holder.getTextViewNom().setText(student.getNom());
        holder.getTextViewPrenom().setText(student.getPrenom());
        holder.getTextViewEmail().setText(student.getEmail());
        holder.getTextViewGroupe().setText(student.getGroupe());
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


}
