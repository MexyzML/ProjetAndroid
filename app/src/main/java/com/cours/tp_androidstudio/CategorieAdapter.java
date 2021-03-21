package com.cours.tp_androidstudio;

import android.content.Intent;
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
        private final TextView textViewTitle;
        private final TextView textViewProductUrl;
        private final View layoutCellCategorie;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewCategorie_id = view.findViewById(R.id.textViewCategorie_id);
            textViewTitle= view.findViewById(R.id.textViewTitle);
            textViewProductUrl = view.findViewById(R.id.textViewProductUrl);
            layoutCellCategorie = view.findViewById(R.id.layoutCellCategorie);
        }

        public TextView getTextViewCategorie_id() {
            return textViewCategorie_id;
        }
        public TextView getTextViewTitle() {
            return textViewTitle;
        }
        public TextView getTextProduct_url() { return textViewProductUrl; }
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
        holder.getTextViewTitle().setText(categorie.getTitle());
        holder.getTextProduct_url().setText(categorie.getProducts_url());
        holder.getLayoutCellCategorie().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductsActivity.class);
                String url = categorie.getProducts_url();
                intent.putExtra("products_url", url);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
