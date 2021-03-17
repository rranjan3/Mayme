package com.amrit.mayme.core;

import java.util.Date;

public class Post {
    String imgSrc;
    String[] tags;
    String title;
    long postId;
    int upVoteCount;
    int downVoteCount;
    int commentCount;
    Date createDate;
    String genre;//TODO: create a Enum type;
    User userId;
    CurUsrAction action = CurUsrAction.NONE;

    public Post(String imgSrc, String[] tags, String title, String genre, int upVoteCount, int downVoteCount) {
        this.imgSrc = imgSrc;
        this.tags = tags;
        this.title = title;
        this.genre = genre;
        this.upVoteCount = upVoteCount;
        this.downVoteCount = downVoteCount;
    }

    public Post(){

    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public CurUsrAction getAction() {
        return action;
    }

    public void setAction(CurUsrAction action) {
        this.action = action;
    }
}
