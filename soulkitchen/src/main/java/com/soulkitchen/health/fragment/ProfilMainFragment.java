package com.soulkitchen.health.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soulkitchen.health.R;
import com.soulkitchen.health.view.PagerSlidingTabStrip;

/**
 * Created by serifenuruysal on 14/06/17.
 */

public class ProfilMainFragment extends BaseFragment {
    ViewPager mViewPager;
    PagerSlidingTabStrip tabs;
    public static ProfilMainFragment newInstance() {
        ProfilMainFragment f = new ProfilMainFragment();
        Bundle localBundle = new Bundle(1);
        f.setArguments(localBundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profil_main, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        tabs=(PagerSlidingTabStrip)view.findViewById(R.id.tabs);
        mViewPager.setOffscreenPageLimit(mViewPager.getAdapter().getCount());
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
                @Override
                public int getCount() {
                    return 2;
                }
                @Override
                public Fragment getItem(int position) {
                    if (position==0){
                        return ProfilSavedTabFragment.newInstance();
                    }else{
                        return ProfilSavedTabFragment.newInstance();
                    }

                }

                @Override
                public CharSequence getPageTitle(int position) {
                    if (position==0){
                        return "KAYDEDİLENLER";
                    }else{
                        return "AYARLAR";
                    }
                }
        });
        tabs.setViewPager(mViewPager);

    }


}
