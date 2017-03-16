package com.soulkitchen.health.pojo;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Ingredients
{
  private String ownerId;
  private Double ingredientsId;
  private Integer ingredientStep;
  private String ingredient;
  private java.util.Date created;
  private java.util.Date updated;
  private String objectId;
  public String getOwnerId()
  {
    return ownerId;
  }

  public Double getIngredientsId()
  {
    return ingredientsId;
  }

  public void setIngredientsId( Double ingredientsId )
  {
    this.ingredientsId = ingredientsId;
  }

  public Integer getIngredientStep()
  {
    return ingredientStep;
  }

  public void setIngredientStep( Integer ingredientStep )
  {
    this.ingredientStep = ingredientStep;
  }

  public String getIngredient()
  {
    return ingredient;
  }

  public void setIngredient( String ingredient )
  {
    this.ingredient = ingredient;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getObjectId()
  {
    return objectId;
  }

                                                    
  public Ingredients save()
  {
    return Backendless.Data.of( Ingredients.class ).save( this );
  }

  public Future<Ingredients> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Ingredients> future = new Future<Ingredients>();
      Backendless.Data.of( Ingredients.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Ingredients> callback )
  {
    Backendless.Data.of( Ingredients.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Ingredients.class ).remove( this );
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
      Backendless.Data.of( Ingredients.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Ingredients.class ).remove( this, callback );
  }

  public static Ingredients findById(String id )
  {
    return Backendless.Data.of( Ingredients.class ).findById( id );
  }

  public static Future<Ingredients> findByIdAsync(String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Ingredients> future = new Future<Ingredients>();
      Backendless.Data.of( Ingredients.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Ingredients> callback )
  {
    Backendless.Data.of( Ingredients.class ).findById( id, callback );
  }

  public static Ingredients findFirst()
  {
    return Backendless.Data.of( Ingredients.class ).findFirst();
  }

  public static Future<Ingredients> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Ingredients> future = new Future<Ingredients>();
      Backendless.Data.of( Ingredients.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Ingredients> callback )
  {
    Backendless.Data.of( Ingredients.class ).findFirst( callback );
  }

  public static Ingredients findLast()
  {
    return Backendless.Data.of( Ingredients.class ).findLast();
  }

  public static Future<Ingredients> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Ingredients> future = new Future<Ingredients>();
      Backendless.Data.of( Ingredients.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Ingredients> callback )
  {
    Backendless.Data.of( Ingredients.class ).findLast( callback );
  }

  public static BackendlessCollection<Ingredients> find(BackendlessDataQuery query )
  {
    return Backendless.Data.of( Ingredients.class ).find( query );
  }

  public static Future<BackendlessCollection<Ingredients>> findAsync(BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Ingredients>> future = new Future<BackendlessCollection<Ingredients>>();
      Backendless.Data.of( Ingredients.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Ingredients>> callback )
  {
    Backendless.Data.of( Ingredients.class ).find( query, callback );
  }
}