package com.soulkitchen.health.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.bumptech.glide.Glide;
import com.soulkitchen.health.CardViewAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.backendless.media.SessionBuilder.TAG;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class ProfilFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private CardViewAdapter adapter;
    private List<Recipies> recipieList;

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view=paramLayoutInflater.inflate(R.layout.fragment_profil, paramViewGroup, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recipieList = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CardViewAdapter(getContext(), recipieList);
        recyclerView.setAdapter(adapter);

//
//        try {
//            Glide.with(this).load(R.drawable.cover).into((ImageView) view.findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return view;
    }

    public static final ProfilFragment newInstance(String paramString) {
        ProfilFragment f = new ProfilFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putString("EXTRA_MESSAGE", paramString);
        f.setArguments(localBundle);
        return f;
    }


    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}