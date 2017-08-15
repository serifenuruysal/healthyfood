package com.soulkitchen.health.pojo;

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

                                                    

}