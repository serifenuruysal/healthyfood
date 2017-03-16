package com.soulkitchen.health.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Categories implements Parcelable
{
  private Integer categoryId;
  private java.util.Date updated;
  private java.util.Date created;
  private String objectId;
  private String ownerId;
  private String categoryNameTr;
  private String categoryImage;

  protected Categories(Parcel in) {
    objectId = in.readString();
    ownerId = in.readString();
    categoryNameTr = in.readString();
    categoryImage = in.readString();
  }
  public Categories() {
  }
  public static final Creator<Categories> CREATOR = new Creator<Categories>() {
    @Override
    public Categories createFromParcel(Parcel in) {
      return new Categories(in);
    }

    @Override
    public Categories[] newArray(int size) {
      return new Categories[size];
    }
  };

  public Integer getCategoryId()
  {
    return categoryId;
  }

  public void setCategoryId( Integer categoryId )
  {
    this.categoryId = categoryId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getCategoryNameTr()
  {
    return categoryNameTr;
  }

  public void setCategoryNameTr( String categoryNameTr )
  {
    this.categoryNameTr = categoryNameTr;
  }

  public String getCategoryImage()
  {
    return categoryImage;
  }

  public void setCategoryImage( String categoryImage )
  {
    this.categoryImage = categoryImage;
  }

                                                    
  public Categories save()
  {
    return Backendless.Data.of( Categories.class ).save( this );
  }

  public Future<Categories> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Categories> future = new Future<Categories>();
      Backendless.Data.of( Categories.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Categories> callback )
  {
    Backendless.Data.of( Categories.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Categories.class ).remove( this );
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
      Backendless.Data.of( Categories.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Categories.class ).remove( this, callback );
  }

  public static Categories findById(String id )
  {
    return Backendless.Data.of( Categories.class ).findById( id );
  }

  public static Future<Categories> findByIdAsync(String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Categories> future = new Future<Categories>();
      Backendless.Data.of( Categories.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Categories> callback )
  {
    Backendless.Data.of( Categories.class ).findById( id, callback );
  }

  public static Categories findFirst()
  {
    return Backendless.Data.of( Categories.class ).findFirst();
  }

  public static Future<Categories> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Categories> future = new Future<Categories>();
      Backendless.Data.of( Categories.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Categories> callback )
  {
    Backendless.Data.of( Categories.class ).findFirst( callback );
  }

  public static Categories findLast()
  {
    return Backendless.Data.of( Categories.class ).findLast();
  }

  public static Future<Categories> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Categories> future = new Future<Categories>();
      Backendless.Data.of( Categories.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Categories> callback )
  {
    Backendless.Data.of( Categories.class ).findLast( callback );
  }

  public static BackendlessCollection<Categories> find(BackendlessDataQuery query )
  {
    return Backendless.Data.of( Categories.class ).find( query );
  }

  public static Future<BackendlessCollection<Categories>> findAsync(BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Categories>> future = new Future<BackendlessCollection<Categories>>();
      Backendless.Data.of( Categories.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Categories>> callback )
  {
    Backendless.Data.of( Categories.class ).find( query, callback );
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(objectId);
    dest.writeString(ownerId);
    dest.writeString(categoryNameTr);
    dest.writeString(categoryImage);
  }
}