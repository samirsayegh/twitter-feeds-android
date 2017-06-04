package com.samirsayegh.twitterapp.domain.entities;

/**
 * Created by Samir DK on 6/4/2017.
 * Samir Dev
 */

public class TwitterUser {

    private long id;
    private String name;
    private String profileImage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
