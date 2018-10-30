package com.swdave.bakingapp.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.swdave.bakingapp.R;
import com.swdave.bakingapp.model.Recipe;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";

    private ArrayList<Recipe> mRecipeArrayList;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail);
            Log.d(TAG, "onCreate: Started ");

            // Get recipe from intent extra
            Intent recipeIntent = getIntent();
            mRecipeArrayList = recipeIntent.getParcelableArrayListExtra("recipes");

            for (int i = 0; i < mRecipeArrayList.size() ; i++) {
                Log.d(TAG, "onCreate: " + i + mRecipeArrayList.get(i).getName());
            }

            Log.d(TAG, "onCreate: Finished ");


    }
}
