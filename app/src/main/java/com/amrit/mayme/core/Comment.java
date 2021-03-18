package com.amrit.mayme.core;

public class Comment {
    String userId;//person who commneted
    String userName;//TODO: may have to save User object.
    String comment;
    int upVoteCount;
    int downVoteCount;

    public Comment(String userName,String comment){
        this.userName = userName;
        this.comment= comment;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
