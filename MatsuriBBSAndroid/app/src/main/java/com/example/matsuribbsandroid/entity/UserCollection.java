package com.example.matsuribbsandroid.entity;

import java.sql.Timestamp;

public class UserCollection {

    private Integer id;
    private Integer pid;
    private Integer uid;
    private Timestamp collectionDate = new Timestamp((new java.util.Date()).getTime());

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Timestamp getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Timestamp collectionDate) {
        this.collectionDate = collectionDate;
    }
}
