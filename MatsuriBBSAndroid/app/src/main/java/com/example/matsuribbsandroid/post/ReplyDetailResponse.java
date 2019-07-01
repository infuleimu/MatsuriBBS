package com.example.matsuribbsandroid.post;

import com.example.matsuribbsandroid.entity.Reply;

public class ReplyDetailResponse {


    /**
     * code : 200
     * error : false
     * message : 成功
     * data : {"id":1,"content":"傻逼楼主,nmsl","replyDate":"2019-06-10T16:00:43.000+0000","likeNum":0,"author":{"id":1,"userName":"1702040031","admin":0}}
     */

    private int code;
    private boolean error;
    private String message;
    private Reply data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reply getData() {
        return data;
    }

    public void setData(Reply data) {
        this.data = data;
    }

}
