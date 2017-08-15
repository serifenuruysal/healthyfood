package com.soulkitchen.health.activity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.ImageView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.soulkitchen.health.R;
import com.soulkitchen.health.fragment.BaseFragment;
import com.soulkitchen.health.fragment.ProfilSavedTabFragment;
import com.soulkitchen.health.fragment.SearchFragment;

/**
 * Created by serifenuruysal on 28/02/17.
 */

public class MainActivity extends AppCompatActivity {
    private AHBottomNavigation bottomNavigation;
    FragmentManager manager = getSupportFragmentManager();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.deepDark));
        }

        bottomNavigation = (AHBottomNavigation)
                findViewById(R.id.bottom_navigation);
        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.text_Home, R.drawable.ic_home, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.text_search, R.drawable.ic_search_white_24dp, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.text_profi, R.drawable.ic_user, R.color.color_tab_3);

// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

// Enable the translation of the FloatingActionButton
//        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#616361"));

// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);
        bottomNavigation.setTranslucentNavigationEnabled(true);

        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);


        bottomNavigation.setColored(true);// Use colored navigation with circle reveal effect
        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

        bottomNavigation.setNotification("1", 2);
// OR
//        AHNotification notification = new AHNotification.Builder()
//                .setText("1")
//                .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.deepDark))
//                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent))
//                .build();
//        bottomNavigation.setNotification(notification, 1);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                BaseFragment fragment = SearchFragment.newInstance("dd");
                switch (position) {
                    case 0:
                        fragment = (BaseFragment) manager.findFragmentByTag(SearchFragment.class.getSimpleName());
                        if (fragment == null) {
                            fragment = SearchFragment.newInstance("action_music");
                            // Write a message to the database
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("message");

                            myRef.setValue("Hello, World!");
                        }

                        break;

                    case 1:
                        fragment = (BaseFragment) manager.findFragmentByTag(SearchFragment.class.getSimpleName());
                        if (fragment == null) {
                            fragment = SearchFragment.newInstance("");
                        }
                        break;
                    case 2:
                        fragment = (BaseFragment) manager.findFragmentByTag(ProfilSavedTabFragment.class.getSimpleName());
                        if (fragment == null) {
                            fragment = ProfilSavedTabFragment.newInstance();
                        }
                        break;


                }
                setFragment(fragment);
                return true;
            }
        });

        BaseFragment fragment = SearchFragment.newInstance("dd");
        setFragment(fragment);


    }

    public void setFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragmentholder, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void openRecipieDetailFragment(BaseFragment fragmentOne, BaseFragment fragmentTwo) {
        // Inflate transitions to apply
        Transition changeTransform = TransitionInflater.from(this).
                inflateTransition(R.transition.change_image_transform);
        Transition explodeTransform = TransitionInflater.from(this).
                inflateTransition(android.R.transition.explode);

        // Setup exit transition on first fragment
        fragmentOne.setSharedElementReturnTransition(changeTransform);
        fragmentOne.setExitTransition(explodeTransform);

        // Setup enter transition on second fragment
        fragmentTwo.setSharedElementEnterTransition(changeTransform);
        fragmentTwo.setEnterTransition(explodeTransform);

        // Find the shared element (in Fragment A)
        ImageView ivProfile = (ImageView) findViewById(R.id.title_icon);

        // Add second fragment by replacing first
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragmentholder, fragmentTwo, fragmentTwo.getClass().getSimpleName())
                .addToBackStack(fragmentTwo.getClass().getSimpleName());
//                .addSharedElement(ivProfile,fragmentTwo.getClass().getSimpleName());
        // Apply the transaction
        fragmentTransaction.commit();
    }


}
