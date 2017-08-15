package com.soulkitchen.health.pojo;

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

                                                    

}