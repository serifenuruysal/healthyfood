package com.soulkitchen.health.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.soulkitchen.health.R;


/**
 * Created by serifenuruysal on 28/02/17.
 */

public class RegisteredActivity extends Activity
{
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registered );
    }

    @Override
    public void onBackPressed()
    {
        setResult( RESULT_OK, new Intent() );
        finish();
    }
}