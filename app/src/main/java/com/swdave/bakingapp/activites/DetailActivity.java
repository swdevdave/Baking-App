package com.swdave.bakingapp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.swdave.bakingapp.R;
import com.swdave.bakingapp.model.Recipe;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {


        ArrayList<Recipe> mRecipeArrayList;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);

            // Get recipe from intent extra
            Intent recipeIntent = getIntent();
            mRecipeArrayList = recipeIntent.getParcelableArrayListExtra("recipes");



    }
}
