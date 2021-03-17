package com.amrit.mayme.core;

import java.util.Set;

public class Vote {
    Set<String> upVoteIds;
    Set<String> downVoteIds;
    long postId;// post whom this vote belongs to
    String userId;//user which created this post
    Boolean curUsrUpvote = null;//? true upvote, false-> downvote, null-> nothing. OR
    // Do we need this or should we just send out list of upvoted/downvoted data from each user. OR
    // Android should maintain this.

    public Set<String> getUpVoteIds() {
        return upVoteIds;
    }

    public void setUpVoteIds(Set<String> upVoteIds) {
        this.upVoteIds = upVoteIds;
    }

    public Set<String> getDownVoteIds() {
        return downVoteIds;
    }

    public void setDownVoteIds(Set<String> downVoteIds) {
        this.downVoteIds = downVoteIds;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
