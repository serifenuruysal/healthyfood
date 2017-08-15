package com.soulkitchen.health.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.soulkitchen.health.R;
import com.soulkitchen.health.adapters.DirectionsAdapter;
import com.soulkitchen.health.adapters.IngredientsAdapter;
import com.soulkitchen.health.pojo.Directions;
import com.soulkitchen.health.pojo.Ingredients;
import com.soulkitchen.health.pojo.Recipies;

import java.util.List;

/**
 * Created by serifenuruysal on 23/03/17.
 */

public class RecipieDetailFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener {

    private RecyclerView rvList;
    private RecyclerView rvList2;
    private List<Directions> directions;
    private List<Ingredients> ingredients;
    private DirectionsAdapter adapter;
    private IngredientsAdapter ingAdapter;
    private KenBurnsView imgAppBar;
    private NestedScrollView nsvContentView;
    private Toolbar toolbar;

    public static RecipieDetailFragment newInstance(Recipies recipie) {
        RecipieDetailFragment f = new RecipieDetailFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("RECIPIE", recipie);
        f.setArguments(localBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipie_detail, container, false);

        rvList = (RecyclerView) view.findViewById(R.id.rvList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(mLayoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());

        rvList2 = (RecyclerView) view.findViewById(R.id.rvList2);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext());
        rvList2.setLayoutManager(mLayoutManager2);
        rvList2.setItemAnimator(new DefaultItemAnimator());

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        Recipies recipie = (Recipies) RecipieDetailFragment.this.getArguments().getParcelable("RECIPIE");
        toolbar.setTitle(recipie.getTitle());

        imgAppBar = (KenBurnsView) view.findViewById(R.id.app_bar_image);
        Glide.with(getContext()).load(recipie.getImageUrl()).centerCrop().into(imgAppBar);

        nsvContentView = (NestedScrollView) view.findViewById(R.id.nsvContentView);

        getIngredients();
        return view;
    }

    private void getDirections() {
        String whereClause = "ownerId ='" + ((Recipies) RecipieDetailFragment.this.getArguments().getParcelable("RECIPIE")).getObjectId() + "'";
//        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
//        dataQuery.setWhereClause(whereClause);
//        Directions.findAsync(dataQuery, new AsyncCallback<BackendlessCollection<Directions>>() {
//            @Override
//            public void handleResponse(BackendlessCollection<Directions> direction) {
//                if (direction != null && direction.getData() != null && direction.getData().size() > 0) {
//                    directions = direction.getData();
//                    adapter = new DirectionsAdapter(getContext(), directions);
//                    rvList.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//                    nsvContentView.setVisibility(View.VISIBLE);
//
//
//                }
//
//            }
//
//            @Override
//            public void handleFault(BackendlessFault backendlessFault) {
//
//            }
//        });
    }

    private void getIngredients() {
        String whereClause = "ownerId ='" + ((Recipies) RecipieDetailFragment.this.getArguments().getParcelable("RECIPIE")).getObjectId() + "'";
//        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
//        dataQuery.setWhereClause(whereClause);
//        Ingredients.findAsync(dataQuery, new AsyncCallback<BackendlessCollection<Ingredients>>() {
//            @Override
//            public void handleResponse(BackendlessCollection<Ingredients> direction) {
//                if (direction != null && direction.getData() != null && direction.getData().size() > 0) {
//                    ingredients = direction.getData();
//                    ingAdapter = new IngredientsAdapter(getContext(), ingredients);
//                    rvList2.setAdapter(ingAdapter);
//                    ingAdapter.notifyDataSetChanged();
//
//                    getDirections();
//
//                }
//
//            }
//
//            @Override
//            public void handleFault(BackendlessFault backendlessFault) {
//
//            }
//        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float alpha = (float) Math.abs(verticalOffset) / appBarLayout.getTotalScrollRange();
        toolbar.setAlpha(alpha);
//        d.setAlpha(1 - alpha);
    }

}
