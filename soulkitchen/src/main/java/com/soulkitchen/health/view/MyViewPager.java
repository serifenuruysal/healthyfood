package com.soulkitchen.health.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by serifenuruysal on 06/03/17.
 */

public class MyViewPager extends ViewPager {

    private boolean enabled;

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }

        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    /**
     * Enable or disable the swipe navigation
     * @param enabled
     */
    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
