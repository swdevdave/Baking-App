package com.swdave.bakingapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepsViewHolder> {

    private Context context;

    public StepsAdapter() {
    }

    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder stepsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class StepsViewHolder extends ViewHolder{

        public StepsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
