package com.soulkitchen.health.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soulkitchen.health.R;
import com.soulkitchen.health.pojo.Recipies;

/**
 * Created by serifenuruysal on 23/03/17.
 */

public class RecipieDetailFragment extends BaseFragment    implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;


    public static RecipieDetailFragment newInstance(Recipies Recipies) {
        RecipieDetailFragment f = new RecipieDetailFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("RECIPIE", Recipies);
        f.setArguments(localBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_recipie_detail, container, false);
        mToolbar        = (Toolbar) view.findViewById(R.id.main_toolbar);
        mTitle          = (TextView) view.findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) view.findViewById(R.id.main_linearlayout_title);
        mAppBarLayout   = (AppBarLayout) view.findViewById(R.id.main_appbar);
        if (mAppBarLayout!=null){
            mAppBarLayout.addOnOffsetChangedListener(this);
        }
        if (mToolbar != null) {
            mToolbar.inflateMenu(R.menu.menu_recipie);
        }

        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        return view;
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage,mTitleContainer);
        handleToolbarTitleVisibility(percentage,mTitle);
    }


}