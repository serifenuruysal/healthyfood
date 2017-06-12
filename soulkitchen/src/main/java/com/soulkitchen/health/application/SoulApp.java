package com.soulkitchen.health.application;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;

import com.backendless.Backendless;
import com.facebook.FacebookSdk;
import com.soulkitchen.health.constants.Defaults;

/**
 * Created by serifenuruysal on 12/03/17.
 */

public class SoulApp extends Application {
    public static final String TAG="Application";
    @Override
    public void onCreate() {
        super.onCreate();

        if (Defaults.APPLICATION_ID.equals("") || Defaults.SECRET_KEY.equals("") || Defaults.VERSION.equals("")) {
            Log.e(TAG, "Missing application ID and secret key arguments. Login to Backendless Console", null);
            return;
        }

        Backendless.initApp(this, Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }

    @Override
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        super.unregisterComponentCallbacks(callback);
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.unregisterActivityLifecycleCallbacks(callback);
    }
}
