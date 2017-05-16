package com.soulkitchen.health.utils;

import com.backendless.BackendlessUser;

/**
 * Created by serifenuruysal on 08/05/17.
 */

public class Session {
    private static Session session;
    private static BackendlessUser user;


    public static Session getSession(){
        if (session==null){
            session=new Session();
        }
        return session;
    }

    public  BackendlessUser getUser() {
        return user;
    }

    public  void setUser(BackendlessUser user) {
        Session.user = user;
    }

}
