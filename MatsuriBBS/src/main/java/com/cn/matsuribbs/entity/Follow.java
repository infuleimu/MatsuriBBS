package com.cn.matsuribbs.entity;

import java.sql.Timestamp;

public class Follow {

    private Integer id;
    private Integer uid;
    private Integer followerId;
    private Timestamp followDate = new Timestamp((new java.util.Date()).getTime());

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
}
