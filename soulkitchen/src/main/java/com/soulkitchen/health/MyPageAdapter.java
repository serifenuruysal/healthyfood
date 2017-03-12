package com.soulkitchen.health;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.soulkitchen.health.fragment.HomeFragment;
import com.soulkitchen.health.fragment.ProfilFragment;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class MyPageAdapter extends FragmentPagerAdapter
{
    FragmentManager fm;
    public MyPageAdapter(FragmentManager fm)
    {
        super(fm);
        this.fm=fm;
    }
    @Override
    public int getCount()
    {
        return 3;
    }
    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0: return HomeFragment.newInstance(fm);
            case 1: return ProfilFragment.newInstance("asdasd");
            case 2: return ProfilFragment.newInstance("asdasd");
            default : return HomeFragment.newInstance(fm);
        }
    }
}