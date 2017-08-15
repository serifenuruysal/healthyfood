package com.soulkitchen.health.pojo;


public class Ingredients {
    private String ownerId;
    private Double ingredientsId;
    private Integer ingredientStep;
    private String ingredient;
    private java.util.Date created;
    private java.util.Date updated;
    private String objectId;

    public String getOwnerId() {
        return ownerId;
    }

    public Double getIngredientsId() {
        return ingredientsId;
    }

    public void setIngredientsId(Double ingredientsId) {
        this.ingredientsId = ingredientsId;
    }

    public Integer getIngredientStep() {
        return ingredientStep;
    }

    public void setIngredientStep(Integer ingredientStep) {
        this.ingredientStep = ingredientStep;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getObjectId() {
        return objectId;
    }


}