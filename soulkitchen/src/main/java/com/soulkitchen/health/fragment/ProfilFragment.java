package com.soulkitchen.health.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soulkitchen.health.R;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class ProfilFragment extends BaseFragment implements AppBarLayout.OnOffsetChangedListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;


    public static ProfilFragment newInstance() {
        ProfilFragment f = new ProfilFragment();
        Bundle localBundle = new Bundle(1);
        f.setArguments(localBundle);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.main_toolbar);
        mTitle = (TextView) view.findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) view.findViewById(R.id.main_linearlayout_title);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.main_appbar);
        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_recipie);
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
        return view;
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage, mTitleContainer);
        handleToolbarTitleVisibility(percentage, mTitle);
    }


}