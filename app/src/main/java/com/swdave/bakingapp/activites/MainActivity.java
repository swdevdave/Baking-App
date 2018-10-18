package com.swdave.bakingapp.activites;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.swdave.bakingapp.R;
import com.swdave.bakingapp.adapters.RecipesAdapter;
import com.swdave.bakingapp.api.ApiInterface;
import com.swdave.bakingapp.api.Constants;
import com.swdave.bakingapp.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String resultJson;
    Gson gson;

    private ApiInterface apiInterface;
    private List<Recipe> recipeList;
    private RecyclerView mRecyclerView;
    private RecipesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recipes);

        mRecyclerView = findViewById(R.id.recipe_rv);
        apiInterface = Constants.getRetrofit().create(ApiInterface.class);
        initViews();
        buildRecipeList();

    }

    private void buildRecipeList() {
        Log.d(TAG, "buildRecipeList: Started");

        Call<List<Recipe>> call = apiInterface.getRecipes();

        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(@NonNull Call<List<Recipe>> call, @NonNull Response<List<Recipe>> response) {

                recipeList = response.body();

                assert recipeList != null;
                Log.d(TAG, "onResponse: " + recipeList.size());
                mAdapter = new RecipesAdapter(MainActivity.this, recipeList);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(@NonNull Call<List<Recipe>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });
    }

    void initViews() {
        Log.d(TAG, "initViews: Started");
        mRecyclerView = findViewById(R.id.recipe_rv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        Log.d(TAG, "initViews: finished");

    }

}
