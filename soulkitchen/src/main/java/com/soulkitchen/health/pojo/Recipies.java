package com.soulkitchen.health.pojo;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Recipies
{
  private Integer ratings;
  private String writer;
  private Integer saturates;
  private java.util.Date created;
  private java.util.Date updated;
  private Double recipieId;
  private Integer protein;
  private String imageUrl;
  private String objectId;
  private Integer sugars;
  private Integer categoryId;
  private String title;
  private String subCategory;
  private Integer energy;
  private String ownerId;
  private Integer fat;
  private Integer serves;
  private String recipieTips;
  private Integer salt;
  private Integer kcal;
  private Integer cookTime;
  private Integer fibre;
  private String level;
  private Integer prepTime;
  private Integer carbs;
  public Integer getRatings()
  {
    return ratings;
  }

  public void setRatings( Integer ratings )
  {
    this.ratings = ratings;
  }

  public String getWriter()
  {
    return writer;
  }

  public void setWriter( String writer )
  {
    this.writer = writer;
  }

  public Integer getSaturates()
  {
    return saturates;
  }

  public void setSaturates( Integer saturates )
  {
    this.saturates = saturates;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public Double getRecipieId()
  {
    return recipieId;
  }

  public void setRecipieId( Double recipieId )
  {
    this.recipieId = recipieId;
  }

  public Integer getProtein()
  {
    return protein;
  }

  public void setProtein( Integer protein )
  {
    this.protein = protein;
  }

  public String getImageUrl()
  {
    return imageUrl;
  }

  public void setImageUrl( String imageUrl )
  {
    this.imageUrl = imageUrl;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Integer getSugars()
  {
    return sugars;
  }

  public void setSugars( Integer sugars )
  {
    this.sugars = sugars;
  }

  public Integer getCategoryId()
  {
    return categoryId;
  }

  public void setCategoryId( Integer categoryId )
  {
    this.categoryId = categoryId;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle( String title )
  {
    this.title = title;
  }

  public String getSubCategory()
  {
    return subCategory;
  }

  public void setSubCategory( String subCategory )
  {
    this.subCategory = subCategory;
  }

  public Integer getEnergy()
  {
    return energy;
  }

  public void setEnergy( Integer energy )
  {
    this.energy = energy;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getFat()
  {
    return fat;
  }

  public void setFat( Integer fat )
  {
    this.fat = fat;
  }

  public Integer getServes()
  {
    return serves;
  }

  public void setServes( Integer serves )
  {
    this.serves = serves;
  }

  public String getRecipieTips()
  {
    return recipieTips;
  }

  public void setRecipieTips( String recipieTips )
  {
    this.recipieTips = recipieTips;
  }

  public Integer getSalt()
  {
    return salt;
  }

  public void setSalt( Integer salt )
  {
    this.salt = salt;
  }

  public Integer getKcal()
  {
    return kcal;
  }

  public void setKcal( Integer kcal )
  {
    this.kcal = kcal;
  }

  public Integer getCookTime()
  {
    return cookTime;
  }

  public void setCookTime( Integer cookTime )
  {
    this.cookTime = cookTime;
  }

  public Integer getFibre()
  {
    return fibre;
  }

  public void setFibre( Integer fibre )
  {
    this.fibre = fibre;
  }

  public String getLevel()
  {
    return level;
  }

  public void setLevel( String level )
  {
    this.level = level;
  }

  public Integer getPrepTime()
  {
    return prepTime;
  }

  public void setPrepTime( Integer prepTime )
  {
    this.prepTime = prepTime;
  }

  public Integer getCarbs()
  {
    return carbs;
  }

  public void setCarbs( Integer carbs )
  {
    this.carbs = carbs;
  }

                                                    
  public Recipies save()
  {
    return Backendless.Data.of( Recipies.class ).save( this );
  }

  public Future<Recipies> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Recipies> future = new Future<Recipies>();
      Backendless.Data.of( Recipies.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Recipies> callback )
  {
    Backendless.Data.of( Recipies.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Recipies.class ).remove( this );
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
      Backendless.Data.of( Recipies.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Recipies.class ).remove( this, callback );
  }

  public static Recipies findById(String id )
  {
    return Backendless.Data.of( Recipies.class ).findById( id );
  }

  public static Future<Recipies> findByIdAsync(String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Recipies> future = new Future<Recipies>();
      Backendless.Data.of( Recipies.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Recipies> callback )
  {
    Backendless.Data.of( Recipies.class ).findById( id, callback );
  }

  public static Recipies findFirst()
  {
    return Backendless.Data.of( Recipies.class ).findFirst();
  }

  public static Future<Recipies> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Recipies> future = new Future<Recipies>();
      Backendless.Data.of( Recipies.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Recipies> callback )
  {
    Backendless.Data.of( Recipies.class ).findFirst( callback );
  }

  public static Recipies findLast()
  {
    return Backendless.Data.of( Recipies.class ).findLast();
  }

  public static Future<Recipies> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Recipies> future = new Future<Recipies>();
      Backendless.Data.of( Recipies.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Recipies> callback )
  {
    Backendless.Data.of( Recipies.class ).findLast( callback );
  }

  public static BackendlessCollection<Recipies> find(BackendlessDataQuery query )
  {
    return Backendless.Data.of( Recipies.class ).find( query );
  }

  public static Future<BackendlessCollection<Recipies>> findAsync(BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Recipies>> future = new Future<BackendlessCollection<Recipies>>();
      Backendless.Data.of( Recipies.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Recipies>> callback )
  {
    Backendless.Data.of( Recipies.class ).find( query, callback );
  }
}