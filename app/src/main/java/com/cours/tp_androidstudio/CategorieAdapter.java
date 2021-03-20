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

public class CategorieAdapter extends RecyclerView.Adapter<CategorieAdapter.ViewHolder> {
    MainActivity activity;
    ArrayList<Categorie> categories;

    public CategorieAdapter(MainActivity activity, ArrayList<Categorie> categories){
        this.activity=activity;
        this.categories=categories;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewCategorie_id;
        private final TextView textViewDescription;
        private final ImageView imageViewPicture;
        private final View layoutCellCategorie;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewCategorie_id = view.findViewById(R.id.textViewCategorie_id);
            textViewDescription = view.findViewById(R.id.textViewDescription);
            imageViewPicture = view.findViewById(R.id.imageViewPicture);
            layoutCellCategorie = view.findViewById(R.id.layoutCellCategorie);
        }

        public TextView getTextViewCategorie_id() {
            return textViewCategorie_id;
        }
        public TextView getTextViewDescription() {
            return textViewDescription;
        }
        public ImageView getImageViewPicture() {
            return imageViewPicture;
        }
        public View getLayoutCellCategorie() {
            return layoutCellCategorie;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_categories, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Categorie categorie=categories.get(position);
        holder.getTextViewCategorie_id().setText(categorie.getCategorie_id());
        holder.getTextViewDescription().setText(categorie.getTitle());
        Picasso.get().load(categorie.getProducts_url()).into(holder.getImageViewPicture());
        holder.getLayoutCellCategorie().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageActivity.displayActivity(activity,categorie.getProducts_url(),categorie.getCategorie_id());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
