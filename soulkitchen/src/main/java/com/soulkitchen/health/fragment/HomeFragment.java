package com.soulkitchen.health.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.soulkitchen.health.DefaultCallback;
import com.soulkitchen.health.MyCategoryAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.activity.LoggedInActivity;
import com.soulkitchen.health.pojo.Categories;
import com.soulkitchen.health.pojo.Recipies;

import java.util.List;

import static com.backendless.media.SessionBuilder.TAG;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class HomeFragment extends BaseFragment {
    MaterialViewPager mViewPager;
    private List<Categories> recipieList;
    @Override
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = paramLayoutInflater.inflate(R.layout.fragment_home, paramViewGroup, false);
        mViewPager = (MaterialViewPager) view.findViewById(R.id.materialViewPager);
        retrieveBasicCategoriesRecord();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            ((LoggedInActivity) getActivity()).setSupportActionBar(toolbar);

            ActionBar actionBar = ((LoggedInActivity) getActivity()).getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(false);
        }
    }

    public static final HomeFragment newInstance(String paramString) {
        HomeFragment f = new HomeFragment();
        Bundle localBundle = new Bundle(1);
        localBundle.putString("EXTRA_MESSAGE", paramString);
        f.setArguments(localBundle);
        return f;
    }

    private void retrieveBasicCategoriesRecord()
    {
        if (recipieList!=null){
            setViewPager();
            return;

        }

        BackendlessDataQuery query = new BackendlessDataQuery();
        Categories.findAsync( query, new DefaultCallback<BackendlessCollection<Categories>>( getActivity())
        {
            @Override
            public void handleResponse( BackendlessCollection<Categories> recipies )
            {
                super.handleResponse( recipies );
                if (recipies!=null&&recipies.getData()!=null&&recipies.getData().size()>0){
                    recipieList=recipies.getData();
                    setViewPager();
                }
            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                Log.e(TAG, "handleFault: "+fault.getMessage(),null );
            }
        } );
    }

    private void setViewPager() {
        mViewPager.getViewPager().setAdapter(new MyCategoryAdapter(getChildFragmentManager(),recipieList )) ;

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                return HeaderDesign.fromColorResAndUrl(
                        R.color.white,
                        recipieList.get(page).getCategoryImage());
//                            switch (page) {
//                                case 0:
//                                    return HeaderDesign.fromColorResAndUrl(
//                                            R.color.green,
//                                            "http://phandroid.s3.amazonaws.com/wp-content/uploads/2014/06/android_google_moutain_google_now_1920x1080_wallpaper_Wallpaper-HD_2560x1600_www.paperhi.com_-640x400.jpg");
//                                case 1:
//                                    return HeaderDesign.fromColorResAndUrl(
//                                            R.color.blue,
//                                            "http://www.hdiphonewallpapers.us/phone-wallpapers/540x960-1/540x960-mobile-wallpapers-hd-2218x5ox3.jpg");
//                                case 2:
//                                    return HeaderDesign.fromColorResAndUrl(
//                                            R.color.cyan,
//                                            "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
//                                case 3:
//                                    return HeaderDesign.fromColorResAndUrl(
//                                            R.color.red,
//                                            "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
//                            }

                //execute others actions if needed (ex : modify your header logo)

//                            return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
        mViewPager.getViewPager().setCurrentItem(0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
