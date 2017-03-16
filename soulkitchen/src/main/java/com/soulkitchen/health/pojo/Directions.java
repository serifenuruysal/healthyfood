package com.soulkitchen.health.pojo;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Directions
{
  private Integer stepNumber;
  private Double directionsId;
  private String objectId;
  private String ownerId;
  private String direction;
  private java.util.Date created;
  private java.util.Date updated;
  public Integer getStepNumber()
  {
    return stepNumber;
  }

  public void setStepNumber( Integer stepNumber )
  {
    this.stepNumber = stepNumber;
  }

  public Double getDirectionsId()
  {
    return directionsId;
  }

  public void setDirectionsId( Double directionsId )
  {
    this.directionsId = directionsId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getDirection()
  {
    return direction;
  }

  public void setDirection( String direction )
  {
    this.direction = direction;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public Directions save()
  {
    return Backendless.Data.of( Directions.class ).save( this );
  }

  public Future<Directions> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Directions> future = new Future<Directions>();
      Backendless.Data.of( Directions.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Directions> callback )
  {
    Backendless.Data.of( Directions.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Directions.class ).remove( this );
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
      Backendless.Data.of( Directions.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Directions.class ).remove( this, callback );
  }

  public static Directions findById(String id )
  {
    return Backendless.Data.of( Directions.class ).findById( id );
  }

  public static Future<Directions> findByIdAsync(String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Directions> future = new Future<Directions>();
      Backendless.Data.of( Directions.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Directions> callback )
  {
    Backendless.Data.of( Directions.class ).findById( id, callback );
  }

  public static Directions findFirst()
  {
    return Backendless.Data.of( Directions.class ).findFirst();
  }

  public static Future<Directions> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Directions> future = new Future<Directions>();
      Backendless.Data.of( Directions.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Directions> callback )
  {
    Backendless.Data.of( Directions.class ).findFirst( callback );
  }

  public static Directions findLast()
  {
    return Backendless.Data.of( Directions.class ).findLast();
  }

  public static Future<Directions> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Directions> future = new Future<Directions>();
      Backendless.Data.of( Directions.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Directions> callback )
  {
    Backendless.Data.of( Directions.class ).findLast( callback );
  }

  public static BackendlessCollection<Directions> find(BackendlessDataQuery query )
  {
    return Backendless.Data.of( Directions.class ).find( query );
  }

  public static Future<BackendlessCollection<Directions>> findAsync(BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Directions>> future = new Future<BackendlessCollection<Directions>>();
      Backendless.Data.of( Directions.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Directions>> callback )
  {
    Backendless.Data.of( Directions.class ).find( query, callback );
  }
}