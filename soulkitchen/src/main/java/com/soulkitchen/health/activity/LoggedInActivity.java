package com.soulkitchen.health.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.Menu;
import android.view.MenuItem;

import com.soulkitchen.health.MyPageAdapter;
import com.soulkitchen.health.R;
import com.soulkitchen.health.ZoomOutPageTransformer;
import com.soulkitchen.health.fragment.BaseFragment;
import com.soulkitchen.health.fragment.HomeFragment;
import com.soulkitchen.health.fragment.ProfilFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serifenuruysal on 28/02/17.
 */

public class LoggedInActivity extends FragmentActivity {
    private BottomNavigationView bottomNavigationView;
    private List<BaseFragment> fragments = new ArrayList<>(3);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedin);
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                switchFragment(0,"action_favorites");
                                return true;
                            case R.id.action_schedules:
                                switchFragment(1,"action_schedules");
                                return true;
                            case R.id.action_music:
                                switchFragment(2,"action_music");
                                return true;

                        }
                        return false;
                    }
                });
        buildFragmentsList();
        switchFragment(0,"action_favorites");
//        findViewById( R.id.logoutButton ).setOnClickListener( new View.OnClickListener()
//        {
//            @Override
//            public void onClick( View view )
//            {
//
//                Backendless.Persistence.save( new Club( "1","Riddim" ), new BackendlessCallback<Club>()
//                {
//                    @Override
//                    public void handleResponse( Club club )
//                    {
//                        Log.i( "Comments", "Got new comment from " + club.getClubName() );
//                    }
//                } );
////                Backendless.UserService.
////                Backendless.UserService.logout(new DefaultCallback<Void>( LoggedInActivity.this )
////                {
////                    @Override
////                    public void handleResponse( Void response )
////                    {
////                        super.handleResponse( response );
////                        startActivity( new Intent( getBaseContext(), MainActivity.class ) );
////                        finish();
////                    }
////                } );
//            }
//        } );


    }

    private void buildFragmentsList() {
        HomeFragment callsFragment = HomeFragment.newInstance(getSupportFragmentManager());
        ProfilFragment recentsFragment = ProfilFragment.newInstance("dd");
        HomeFragment tripsFragment = HomeFragment.newInstance(getSupportFragmentManager());
        fragments.add(callsFragment);
        fragments.add(recentsFragment);
        fragments.add(tripsFragment);
    }
//    private void setSelectedItem(int actionId) {
//        Menu menu = bottomNavigationView.getMenu();
//        for (int i = 0, size = menu.size(); i < size; i++) {
//            MenuItem menuItem = menu.getItem(i);
//            ((MenuItemImpl) menuItem).setExclusiveCheckable(false);
//            menuItem.setChecked(menuItem.getItemId() == actionId);
//            ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
//        }
//    }

    private void switchFragment(int pos,String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }
}
