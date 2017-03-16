package com.soulkitchen.health.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.facebook.CallbackManager;
import com.soulkitchen.health.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



//        Map<String, String> twitterFieldsMappings = new HashMap<String, String>();
//        twitterFieldsMappings.put( "name", "twitter_name" );
//
//        Backendless.UserService.loginWithTwitter( this, twitterFieldsMappings, new AsyncCallback<BackendlessUser>()
//        {
//            @Override
//            public void handleResponse( BackendlessUser backendlessUser )
//            {
//                // user logged in successfully
//            }
//
//            @Override
//            public void handleFault( BackendlessFault backendlessFault )
//            {
//                // failed to log in
//            }
//        } );


        callbackManager = CallbackManager.Factory.create();

        final EditText emailField = (EditText) findViewById(R.id.emailField);
        final EditText passwordField = (EditText) findViewById(R.id.passwordField);

        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, String> facebookFieldsMappings = new HashMap<>();
                facebookFieldsMappings.put("email", "email");
                facebookFieldsMappings.put("first_name", "fb_first_name");
                facebookFieldsMappings.put("last_name", "fb_last_name");
                facebookFieldsMappings.put("gender", "fb_gender");

                List<String> permissions = new ArrayList<>();
                permissions.add("email");
                permissions.add("public_profile");

                Backendless.UserService.loginWithFacebookSdk(MainActivity.this, facebookFieldsMappings, permissions, callbackManager, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser backendlessUser) {
                        Toast toast = Toast.makeText(MainActivity.this, "Ok, User ID =" + backendlessUser.getUserId(), Toast.LENGTH_LONG);
                        toast.show();
                    }

                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Toast toast = Toast.makeText(MainActivity.this, backendlessFault.toString(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
//                Backendless.UserService.login( emailField.getText().toString(), passwordField.getText().toString(), new DefaultCallback<BackendlessUser>( MainActivity.this )
//                Backendless.UserService.login("serifenuruysal@gmail.com", "Samatya11", new DefaultCallback<BackendlessUser>(MainActivity.this) {
//                    public void handleResponse(BackendlessUser backendlessUser) {
//
//                        super.handleResponse(backendlessUser);
//                        startActivity(new Intent(getBaseContext(), LoggedInActivity.class));
//                    }
//                });
            }
        });

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });
    }

    public static void showAlert(final Activity context, String message) {
        new AlertDialog.Builder(context).setTitle("An error occurred").setMessage(message).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.finish();
            }
        }).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        startActivity(new Intent(getBaseContext(), LoggedInActivity.class));
    }
}
