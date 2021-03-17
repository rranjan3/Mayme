package com.amrit.mayme.core;

import java.util.List;

public class User {
    private String userName;
    private String userID;
    private String password;
    private String profileImageSrc;
    private int activeDays;
    private List<Post> postList;
    String userMembership;//TODO: crate enum for this. Also policy is future thing.

    public User(String userName, String userID, String password, int activeDays) {
        this.userName = userName;
        this.userID = userID;
        this.password = password;
        this.activeDays = activeDays;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImageSrc() {
        return profileImageSrc;
    }

    public void setProfileImageSrc(String profileImageSrc) {
        this.profileImageSrc = profileImageSrc;
    }

    public int getActiveDays() {
        return activeDays;
    }

    public void setActiveDays(int activeDays) {
        this.activeDays = activeDays;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
