package com.soulkitchen.health.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Directions;
import com.soulkitchen.health.pojo.Ingredients;
import com.soulkitchen.health.view.CustomTextView;

import java.util.List;

/**
 * Created by serifenuruysal on 13/06/17.
 */

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.DirectionsAdapterViewHolder> {
    private Context mContext;
    private List<Ingredients> ingredientsList;

    public IngredientsAdapter(Context context, List<Ingredients> ingredients) {
        this.ingredientsList=ingredients;
        this.mContext=context;

    }

    public class DirectionsAdapterViewHolder extends RecyclerView.ViewHolder {
        public CustomTextView title;
        public ImageView imgStep;

        public DirectionsAdapterViewHolder(View view) {
            super(view);
            title = (CustomTextView) view.findViewById(R.id.tvTitle);
            imgStep = (ImageView) view.findViewById(R.id.ivStepImage);
        }
    }

    @Override
    public IngredientsAdapter.DirectionsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.step_card, parent, false);

        return new IngredientsAdapter.DirectionsAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IngredientsAdapter.DirectionsAdapterViewHolder holder, int position) {
        Ingredients ingredients=ingredientsList.get(position);
        holder.title.setText(ingredients.getIngredient());
        switch (position){
            case 0:
                holder.imgStep.setImageResource(R.drawable.ic_one);
                break;
            case 1:
                holder.imgStep.setImageResource(R.drawable.ic_two);
                break;
            case 2:
                holder.imgStep.setImageResource(R.drawable.ic_three);
                break;
            case 3:
                holder.imgStep.setImageResource(R.drawable.ic_four);
                break;
            case 4:
                holder.imgStep.setImageResource(R.drawable.ic_five);
                break;
            case 5:
                holder.imgStep.setImageResource(R.drawable.ic_six);
                break;
            case 6:
                holder.imgStep.setImageResource(R.drawable.ic_seven);
                break;
            case 7:
                holder.imgStep.setImageResource(R.drawable.ic_eight);
                break;
            case 8:
                holder.imgStep.setImageResource(R.drawable.ic_nine);
                break;
        }
        holder.imgStep.setColorFilter(mContext.getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);

    }

    @Override
    public int getItemCount() {
        return ingredientsList!=null?ingredientsList.size():0;
    }
}
