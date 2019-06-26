package com.example.matsuribbsandroid.post;

import com.example.matsuribbsandroid.entity.Post;

public class PostDetailResponse {


    /**
     * code : 200
     * error : false
     * message : 成功
     * data : {"id":1,"title":"嘻嘻哈哈","content":"喂喂喂","postDate":"2019-06-04T00:00:00.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"id":1,"userName":"迪克","admin":0}}
     */

    private int code;
    private boolean error;
    private String message;
    private Post data;

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

    public Post getData() {
        return data;
    }

    public void setData(Post data) {
        this.data = data;
    }
}
