package com.example.matsuribbsandroid.entity;


import java.sql.Timestamp;
import java.util.List;

public class Reply {

    private Integer id;
    private Integer uid;
    private Integer pid;
    private String content;
    private Timestamp replyDate = new Timestamp((new java.util.Date()).getTime());
    private Integer likeNum = 0;

    private User author;

    private List<SubReply> subReply;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Timestamp replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<SubReply> getSubReply() {
        return subReply;
    }

    public void setSubReply(List<SubReply> subReply) {
        this.subReply = subReply;
    }
}
