package com.cn.matsuribbs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Timestamp;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class Follow {

    private Integer id;
    private Integer uid;
    private Integer followerId;
    @JsonIgnore
    private Timestamp followDate = new Timestamp((new java.util.Date()).getTime());

    private User follow;
    private User follower;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }

    public Timestamp getFollowDate() {
        return followDate;
    }

    public void setFollowDate(Timestamp followDate) {
        this.followDate = followDate;
    }

    public User getFollow() {
        return follow;
    }

    public void setFollow(User follow) {
        this.follow = follow;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }
}
