package com.soulkitchen.health;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.soulkitchen.health.fragment.CategoryFragment;
import com.soulkitchen.health.pojo.Categories;

import java.util.List;

/**
 * Created by serifenuruysal on 07/03/17.
 */

public class MyCategoryAdapter extends FragmentPagerAdapter
{
    FragmentManager fm;
    List<Categories> recipieList;
    public MyCategoryAdapter(FragmentManager fm, List<Categories> recipieList)
    {
        super(fm);
        this.recipieList=recipieList;
    }

    @Override
    public Fragment getItem(int position) {
         return CategoryFragment.newInstance(recipieList.get(position).getCategoryId());
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    @Override
    public int getCount() {
        return recipieList!=null?recipieList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return recipieList.get(position).getCategoryNameTr();
    }
}