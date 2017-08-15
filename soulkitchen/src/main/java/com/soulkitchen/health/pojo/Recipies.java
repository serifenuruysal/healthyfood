package com.soulkitchen.health.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Recipies implements Parcelable {
    private Integer ratings;
    private String writer;
    private Integer saturates;

    private Double recipieId;
    private Integer protein;
    private String imageUrl;
    private String objectId;
    private Integer sugars;
    private Integer likeCount;
    private Integer categoryId;
    private Integer saveCount;
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
    private String likeUsers;

    public Recipies() {
    }

    protected Recipies(Parcel in) {
        writer = in.readString();
        imageUrl = in.readString();
        objectId = in.readString();
        title = in.readString();
        subCategory = in.readString();
        ownerId = in.readString();
        recipieTips = in.readString();
        level = in.readString();
        likeUsers = in.readString();
    }

    public static final Creator<Recipies> CREATOR = new Creator<Recipies>() {
        @Override
        public Recipies createFromParcel(Parcel in) {
            return new Recipies(in);
        }

        @Override
        public Recipies[] newArray(int size) {
            return new Recipies[size];
        }
    };

    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getSaturates() {
        return saturates;
    }

    public void setSaturates(Integer saturates) {
        this.saturates = saturates;
    }


    public String getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(String likeUsers) {
        this.likeUsers = likeUsers;
    }

    public Double getRecipieId() {
        return recipieId;
    }

    public void setRecipieId(Double recipieId) {
        this.recipieId = recipieId;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getObjectId() {
        return objectId;
    }

    public Integer getSugars() {
        return sugars;
    }

    public void setSugars(Integer sugars) {
        this.sugars = sugars;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSaveCount() {
        return saveCount;
    }

    public void setSaveCount(Integer saveCount) {
        this.saveCount = saveCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    public String getRecipieTips() {
        return recipieTips;
    }

    public void setRecipieTips(String recipieTips) {
        this.recipieTips = recipieTips;
    }

    public Integer getSalt() {
        return salt;
    }

    public void setSalt(Integer salt) {
        this.salt = salt;
    }

    public Integer getKcal() {
        return kcal;
    }

    public void setKcal(Integer kcal) {
        this.kcal = kcal;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getFibre() {
        return fibre;
    }

    public void setFibre(Integer fibre) {
        this.fibre = fibre;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(writer);
        dest.writeString(imageUrl);
        dest.writeString(objectId);
        dest.writeString(title);
        dest.writeString(subCategory);
        dest.writeString(ownerId);
        dest.writeString(recipieTips);
        dest.writeString(level);
        dest.writeString(likeUsers);
    }
}