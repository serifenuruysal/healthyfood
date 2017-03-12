package com.soulkitchen.health.pojo;

/**
 * Created by serifenuruysal on 09/03/17.
 */

public class Recipies {
    private String writer;
    private String title;
    private int salt;
    private int serves;
    private int sugars;
    private int saturates;
    private double recipieId;
    private String recipieTips;
    private int ratings;
    private int prepTime;
    private int protein;
    private String level;
    private int kcal;
    private String imageUrl;
    private int fibre;
    private int fat;
    private int energy;
    private int carbs;
    private int cookTime;

    public Recipies(){

    }

    public Recipies(String writer, String title, int salt, int serves, int sugars, int saturates, double recipieId, String recipieTips, int ratings, int prepTime, int protein, String level, int kcal, String imageUrl, int fibre, int fat, int energy, int carbs, int cookTime) {
        this.writer = writer;
        this.title = title;
        this.salt = salt;
        this.serves = serves;
        this.sugars = sugars;
        this.saturates = saturates;
        this.recipieId = recipieId;
        this.recipieTips = recipieTips;
        this.ratings = ratings;
        this.prepTime = prepTime;
        this.protein = protein;
        this.level = level;
        this.kcal = kcal;
        this.imageUrl = imageUrl;
        this.fibre = fibre;
        this.fat = fat;
        this.energy = energy;
        this.carbs = carbs;
        this.cookTime = cookTime;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }

    public int getServes() {
        return serves;
    }

    public void setServes(int serves) {
        this.serves = serves;
    }

    public int getSugars() {
        return sugars;
    }

    public void setSugars(int sugars) {
        this.sugars = sugars;
    }

    public int getSaturates() {
        return saturates;
    }

    public void setSaturates(int saturates) {
        this.saturates = saturates;
    }

    public double getRecipieId() {
        return recipieId;
    }

    public void setRecipieId(double recipieId) {
        this.recipieId = recipieId;
    }

    public String getRecipieTips() {
        return recipieTips;
    }

    public void setRecipieTips(String recipieTips) {
        this.recipieTips = recipieTips;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getFibre() {
        return fibre;
    }

    public void setFibre(int fibre) {
        this.fibre = fibre;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }
}
