package com.soulkitchen.health.pojo;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class SavedRecipies
{
  private String recipieId;
  private String objectId;

  public SavedRecipies() {
  }

  public SavedRecipies(String recipieId) {
    this.recipieId = recipieId;
  }

  private java.util.Date created;
  private java.util.Date updated;
  private String ownerId;
  public String getRecipieId()
  {
    return recipieId;
  }

  public void setRecipieId( String recipieId )
  {
    this.recipieId = recipieId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }


  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public SavedRecipies save()
  {
    return Backendless.Data.of( SavedRecipies.class ).save( this );
  }

  public Future<SavedRecipies> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<SavedRecipies> future = new Future<SavedRecipies>();
      Backendless.Data.of( SavedRecipies.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<SavedRecipies> callback )
  {
    Backendless.Data.of( SavedRecipies.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( SavedRecipies.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( SavedRecipies.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( SavedRecipies.class ).remove( this, callback );
  }

  public static SavedRecipies findById( String id )
  {
    return Backendless.Data.of( SavedRecipies.class ).findById( id );
  }

  public static Future<SavedRecipies> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<SavedRecipies> future = new Future<SavedRecipies>();
      Backendless.Data.of( SavedRecipies.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<SavedRecipies> callback )
  {
    Backendless.Data.of( SavedRecipies.class ).findById( id, callback );
  }

  public static SavedRecipies findFirst()
  {
    return Backendless.Data.of( SavedRecipies.class ).findFirst();
  }

  public static Future<SavedRecipies> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<SavedRecipies> future = new Future<SavedRecipies>();
      Backendless.Data.of( SavedRecipies.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<SavedRecipies> callback )
  {
    Backendless.Data.of( SavedRecipies.class ).findFirst( callback );
  }

  public static SavedRecipies findLast()
  {
    return Backendless.Data.of( SavedRecipies.class ).findLast();
  }

  public static Future<SavedRecipies> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<SavedRecipies> future = new Future<SavedRecipies>();
      Backendless.Data.of( SavedRecipies.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<SavedRecipies> callback )
  {
    Backendless.Data.of( SavedRecipies.class ).findLast( callback );
  }

  public static BackendlessCollection<SavedRecipies> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( SavedRecipies.class ).find( query );
  }

  public static Future<BackendlessCollection<SavedRecipies>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<SavedRecipies>> future = new Future<BackendlessCollection<SavedRecipies>>();
      Backendless.Data.of( SavedRecipies.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<SavedRecipies>> callback )
  {
    Backendless.Data.of( SavedRecipies.class ).find( query, callback );
  }
}