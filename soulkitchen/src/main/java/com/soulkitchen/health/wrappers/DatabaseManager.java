package com.soulkitchen.health.wrappers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.soulkitchen.health.utils.Session;

/**
 * Created by serifenuruysal on 29/07/17.
 */

public class DatabaseManager {
    private static FirebaseDatabase database;
    private static DatabaseManager mngr;


    public static DatabaseManager getInstance(){
        if (mngr==null){
            database=FirebaseDatabase.getInstance();
            mngr=new DatabaseManager();
        }
        return mngr;
    }

    public static DatabaseReference getCategoryRef(){
        return database.getReference("categories");
    }

    public static DatabaseReference getRecipieRef(){
        return database.getReference("recipies");
    }

    public static DatabaseReference getSavedRecipie(){
        return database.getReference("savedRecipie");
    }
    public static DatabaseReference getRef(){
        return database.getReference();
    }

}
