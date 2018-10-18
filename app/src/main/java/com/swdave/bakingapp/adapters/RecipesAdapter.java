package com.swdave.bakingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.swdave.bakingapp.R;
import com.swdave.bakingapp.activites.DetailActivity;
import com.swdave.bakingapp.model.Recipe;

import java.util.ArrayList;
import java.util.List;


public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    private static final String TAG = "RecipesAdapter";

    private Context mContext;
    private List<Recipe> mRecipeList;


    public RecipesAdapter(Context context, List<Recipe> recipes) {
        this.mContext = context;
        this.mRecipeList = recipes;
    }


    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recipe_list_item, parent, false);

        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder viewHolder, final int position) {

        Glide.with(mContext)
                .load(R.drawable.mixing)
                .into(viewHolder.bowl);

        Glide.with(mContext)
                .load(R.drawable.ic_keyboard_arrow_right_black)
                .into(viewHolder.arrowRight);

        viewHolder.recipeName.setText(mRecipeList.get(position).getName());
        viewHolder.servingsQuantity.setText(mRecipeList.get(position).getServings());



        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe recipe = mRecipeList.get(position);
                Intent intent = new Intent(mContext, DetailActivity.class);
                ArrayList<Recipe> recipeArrayList = new ArrayList<>();
                recipeArrayList.add(recipe);
                intent.putParcelableArrayListExtra("recipes", recipeArrayList);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    static class RecipeViewHolder extends ViewHolder{
        ImageView bowl, arrowRight;
        TextView recipeName;
        TextView servings;
        TextView servingsQuantity;
        CardView parentLayout;

        RecipeViewHolder(@NonNull View itemView) {

            super(itemView);
            arrowRight = itemView.findViewById(R.id.arrow_right);
            bowl = itemView.findViewById(R.id.recipe_iv);
            recipeName = itemView.findViewById(R.id.recipe_tv);
            servings = itemView.findViewById(R.id.servings_title);
            servingsQuantity = itemView.findViewById(R.id.servings_quantity_tv);
            parentLayout = itemView.findViewById(R.id.recipe_cv);
        }
    }

}
