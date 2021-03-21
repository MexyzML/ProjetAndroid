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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    MainActivity activity;
    ArrayList<Product> products ;

    public ProductAdapter(MainActivity activity, ArrayList<Product> Products){
        this.activity=activity;
        this.products=products;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewDescription;
        private final ImageView imageViewPicture;
        private final View layoutCellProduct;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewName = view.findViewById(R.id.textViewName);
            textViewDescription = view.findViewById(R.id.textViewDescription);
            imageViewPicture = view.findViewById(R.id.imageViewPicture);
            layoutCellProduct = view.findViewById(R.id.layoutCellProduct);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewDescription() {
            return textViewDescription;
        }
        public ImageView getImageViewPicture() {
            return imageViewPicture;
        }
        public View getLayoutCellProduct() {
            return layoutCellProduct;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_products, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product product=products.get(position);
        holder.getTextViewName().setText(product.getName());
        holder.getTextViewDescription().setText(product.getdescription());
        Picasso.get().load(product.getPicture_url()).into(holder.getImageViewPicture());
        holder.getLayoutCellProduct().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductPageActivity.displayActivity(activity,product.getPicture_url(),product.getName(), product.getdescription());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
