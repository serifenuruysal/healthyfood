package com.soulkitchen.health.pojo;

/**
 * Created by serifenuruysal on 01/03/17.
 */

public class Club  {
    private String clubId;
    private String clubName;

    public Club() {
    }

    public Club(String clubId, String clubName) {
        this.clubId = clubId;
        this.clubName = clubName;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}