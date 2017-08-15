package com.soulkitchen.health.pojo;

import android.os.Parcel;
import android.os.Parcelable;

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