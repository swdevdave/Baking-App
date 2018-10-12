package com.swdave.bakingapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.swdave.bakingapp.adapters.RecipesAdapter;
import com.swdave.bakingapp.api.ApiInterface;
import com.swdave.bakingapp.model.Recipe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public static final String BASE_URL = "http://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/";
    private ApiInterface mApiInterface;
    private ArrayList<Recipe> mRecipes;
    private RecyclerView mRecyclerView;
    private RecipesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recipes);

        mRecyclerView = findViewById(R.id.recipe_rv);

        buildBaseUrl();

    }

    private void buildBaseUrl() {

        Log.d(TAG, "buildBaseUrl: Started");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiInterface = retrofit.create(ApiInterface.class);
        Log.d(TAG, "buildBaseUrl: finished before call all recipes");
        initViews();

    }

    private void callRecipes(){
        Log.d(TAG, "callRecipes: Started");
        if (mRecipes == null){
            Call<List<Recipe>> call = mApiInterface.getRecipes();

            call.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(@NonNull Call<List<Recipe>> call, @NonNull Response<List<Recipe>> response) {

                    assert response.body() != null;
                    mRecipes = new ArrayList<>(response.body());

                    Log.d(TAG, "onResponse: " + mRecipes.size());

                    mAdapter = new RecipesAdapter(getApplicationContext(), mRecipes);

                    mRecyclerView.setAdapter(mAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<List<Recipe>> call, Throwable t) {

                }
            });


        }
        Log.d(TAG, "callRecipes: finished");

    }

    void initViews(){
        Log.d(TAG, "initViews: Started");
        mRecyclerView = findViewById(R.id.recipe_rv);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        Log.d(TAG, "initViews: finished");
        callRecipes();
    }

}
