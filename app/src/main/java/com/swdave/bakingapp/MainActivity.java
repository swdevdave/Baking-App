package com.swdave.bakingapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.swdave.bakingapp.api.ApiInterface;
import com.swdave.bakingapp.model.Recipe;

import java.util.ArrayList;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildBaseUrl();
        callRecipes();


    }

    private void buildBaseUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiInterface = retrofit.create(ApiInterface.class);

    }

    private void callRecipes(){

        if (mRecipes == null){
            Call<List<Recipe>> call = mApiInterface.getRecipes();
            call.enqueue(new Callback<List<Recipe>>() {
                @Override
                public void onResponse(@NonNull Call<List<Recipe>> call, @NonNull Response<List<Recipe>> response) {
                    mRecipes = (ArrayList<Recipe>) response.body();
                    Log.d(TAG, "onResponse: " + mRecipes.size());


                }

                @Override
                public void onFailure(@NonNull Call<List<Recipe>> call, Throwable t) {

                }
            });


        }

    }

}
