package com.soulkitchen.health.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.soulkitchen.health.DefaultCallback;
import com.soulkitchen.health.Defaults;
import com.soulkitchen.health.R;
import com.soulkitchen.health.utils.Session;
import com.soulkitchen.health.utils.SocialCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreLoginActivity extends Activity {
    private TextView registerLink, restoreLink;
    private EditText identityField, passwordField;
    private Button loginButton;
    private CheckBox rememberLoginBox;
    private Button facebookButton;
    private Button twitterButton;
    private Button googleButton;

    @Override
    public void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.prelogin_activity );

        initUI();

        Backendless.setUrl( Defaults.SERVER_URL );
        Backendless.initApp( this, Defaults.APPLICATION_ID, Defaults.SECRET_KEY, Defaults.VERSION );

        Backendless.UserService.isValidLogin( new DefaultCallback<Boolean>( this )
        {
            @Override
            public void handleResponse( Boolean isValidLogin )
            {
                if( isValidLogin && Backendless.UserService.CurrentUser() == null )
                {
                    String currentUserId = Backendless.UserService.loggedInUser();

                    if( !currentUserId.equals( "" ) )
                    {
                        Backendless.UserService.findById( currentUserId, new DefaultCallback<BackendlessUser>( PreLoginActivity.this )
                        {
                            @Override
                            public void handleResponse( BackendlessUser currentUser )
                            {
                                super.handleResponse( currentUser );
                                Backendless.UserService.setCurrentUser( currentUser );
                                startActivity( new Intent( getBaseContext(), MainActivity.class ) );
                                finish();
                            }
                        } );
                    }
                }

                super.handleResponse( isValidLogin );
            }
        });

        onLoginWithFacebookButtonClicked();
    }

    private void initUI()
    {
        registerLink = (TextView) findViewById( R.id.registerLink );
        restoreLink = (TextView) findViewById( R.id.restoreLink );
        identityField = (EditText) findViewById( R.id.identityField );
        passwordField = (EditText) findViewById( R.id.passwordField );
        loginButton = (Button) findViewById( R.id.loginButton );
        rememberLoginBox = (CheckBox) findViewById( R.id.rememberLoginBox );
        facebookButton = (Button) findViewById( R.id.loginFacebookButton );
        twitterButton = (Button) findViewById( R.id.loginTwitterButton );
        googleButton = (Button) findViewById(R.id.loginGoogleButton);

        String tempString = getResources().getString( R.string.register_text );
        SpannableString underlinedContent = new SpannableString( tempString );
        underlinedContent.setSpan( new UnderlineSpan(), 0, tempString.length(), 0 );
        registerLink.setText( underlinedContent );
        tempString = getResources().getString( R.string.restore_link );
        underlinedContent = new SpannableString( tempString );
        underlinedContent.setSpan( new UnderlineSpan(), 0, tempString.length(), 0 );
        restoreLink.setText( underlinedContent );

        loginButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onLoginButtonClicked();
            }
        } );

        registerLink.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onRegisterLinkClicked();
            }
        } );

        restoreLink.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onRestoreLinkClicked();
            }
        } );

        facebookButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onLoginWithFacebookButtonClicked();
            }
        } );

        twitterButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onLoginWithTwitterButtonClicked();
            }
        } );

        googleButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                onLoginWithGoogleButtonClicked();
            }
        });

    }

    public void onLoginButtonClicked()
    {
        String identity = identityField.getText().toString();
        String password = passwordField.getText().toString();
        boolean rememberLogin = rememberLoginBox.isChecked();

        Backendless.UserService.login( identity, password, new DefaultCallback<BackendlessUser>( PreLoginActivity.this )
        {
            public void handleResponse( BackendlessUser backendlessUser )
            {
                super.handleResponse( backendlessUser );
                Session.getSession().setUser(backendlessUser);
                startActivity( new Intent( PreLoginActivity.this, MainActivity.class ) );
                finish();
            }
        }, rememberLogin );
    }

    public void onRegisterLinkClicked()
    {
        startActivity( new Intent( this, RegisterActivity.class ) );
        finish();
    }

    public void onRestoreLinkClicked()
    {
        startActivity( new Intent( this, RestorePasswordActivity.class ) );
        finish();
    }

    public void onLoginWithFacebookButtonClicked()
    {
        Map<String, String> facebookFieldsMapping = new HashMap<>();
        facebookFieldsMapping.put( "name", "name" );
        facebookFieldsMapping.put( "gender", "gender" );
        facebookFieldsMapping.put( "email", "email" );

        List<String> facebookPermissions = new ArrayList<>();
        facebookPermissions.add( "email" );

        Backendless.UserService.loginWithFacebook( PreLoginActivity.this, null, facebookFieldsMapping, facebookPermissions, new SocialCallback<BackendlessUser>( PreLoginActivity.this )
        {
            @Override
            public void handleResponse( BackendlessUser backendlessUser )
            {
                Session.getSession().setUser(backendlessUser);
                startActivity( new Intent( getBaseContext(), MainActivity.class ) );
                finish();
            }
        } );
    }

    public void onLoginWithTwitterButtonClicked()
    {
        Map<String, String> twitterFieldsMapping = new HashMap<>();
        twitterFieldsMapping.put( "name", "name" );

        Backendless.UserService.loginWithTwitter( PreLoginActivity.this, twitterFieldsMapping, new SocialCallback<BackendlessUser>( PreLoginActivity.this )
        {
            @Override
            public void handleResponse( BackendlessUser backendlessUser )
            {
                Session.getSession().setUser(backendlessUser);
                startActivity( new Intent( getBaseContext(), MainActivity.class ) );
                finish();
            }
        } );
    }

    public void onLoginWithGoogleButtonClicked()
    {
        Map<String, String> googleFieldsMapping = new HashMap<>();
        googleFieldsMapping.put( "name", "name" );
        googleFieldsMapping.put( "gender", "gender" );
        googleFieldsMapping.put( "email", "email" );

        List<String> googlePermissions = new ArrayList<>();

        Backendless.UserService.loginWithGooglePlus( PreLoginActivity.this, null, googleFieldsMapping, googlePermissions, new SocialCallback<BackendlessUser>( PreLoginActivity.this )
        {
            @Override
            public void handleResponse( BackendlessUser backendlessUser )
            {
                Session.getSession().setUser(backendlessUser);
                startActivity( new Intent( getBaseContext(), MainActivity.class ) );
                finish();
            }
        });
    }

}
