package com.soulkitchen.health.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.soulkitchen.health.R;
import com.soulkitchen.health.fragment.BaseFragment;
import com.soulkitchen.health.fragment.HomeFragment;
import com.soulkitchen.health.fragment.ProfilFragment;
import com.soulkitchen.health.fragment.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serifenuruysal on 28/02/17.
 */

public class LoggedInActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    FragmentManager manager = getSupportFragmentManager();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggedin);
        bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                        BaseFragment fragment = HomeFragment.newInstance("dd");
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                fragment = (BaseFragment) manager.findFragmentByTag(HomeFragment.class.getSimpleName());
                                if (fragment == null) {
                                    fragment = HomeFragment.newInstance("dd");
                                }
                                break;

                            case R.id.action_schedules:
                                fragment = (BaseFragment) manager.findFragmentByTag(ProfilFragment.class.getSimpleName());
                                if (fragment == null) {
                                    fragment = ProfilFragment.newInstance("dd");
                                }
                                break;
                            case R.id.action_music:
                                fragment = (BaseFragment) manager.findFragmentByTag(SettingsFragment.class.getSimpleName());
                                if (fragment == null) {
                                    fragment = SettingsFragment.newInstance("action_music");
                                }
                                break;

                        }
                        setFragment(fragment);
                        return true;
                    }
                });

        BaseFragment fragment = HomeFragment.newInstance("dd");
        setFragment(fragment);
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
//
//    private void buildFragmentsList() {
//        HomeFragment callsFragment = HomeFragment.newInstance("dd");
//        ProfilFragment recentsFragment = ProfilFragment.newInstance("dd");
//        HomeFragment tripsFragment = HomeFragment.newInstance("mjb");
//        fragments.add(callsFragment);
//        fragments.add(recentsFragment);
//        fragments.add(tripsFragment);
//    }
//    private void setSelectedItem(int actionId) {
//        Menu menu = bottomNavigationView.getMenu();
//        for (int i = 0, size = menu.size(); i < size; i++) {
//            MenuItem menuItem = menu.getItem(i);
//            ((MenuItemImpl) menuItem).setExclusiveCheckable(false);
//            menuItem.setChecked(menuItem.getItemId() == actionId);
//            ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
//        }
//    }

//    private void switchFragment(int pos,String tag) {
//
//        FragmentTransaction fragmentTransaction = manager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_fragmentholder, fragment, fragment.getClass().getSimpleName());
//        fragmentTransaction.commit;
//    }

    public void setFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_fragmentholder, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

}
