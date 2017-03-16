package com.soulkitchen.health.fragment;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soulkitchen.health.CardViewAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class SettingsFragment extends BaseFragment {
    private CardViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view=paramLayoutInflater.inflate(R.layout.fragment_profil, paramViewGroup, false);

        return view;
    }

    public static final SettingsFragment newInstance(String paramString) {
        SettingsFragment f = new SettingsFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putString("EXTRA_MESSAGE", paramString);
        f.setArguments(localBundle);
        return f;
    }


}