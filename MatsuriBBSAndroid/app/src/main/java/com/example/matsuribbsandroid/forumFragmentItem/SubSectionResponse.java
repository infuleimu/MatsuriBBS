package com.example.matsuribbsandroid.forumFragmentItem;

import com.example.matsuribbsandroid.entity.SubSection;

import java.util.List;

public class SubSectionResponse {

    /**
     * code : 200
     * error : false
     * message : 成功
     * data : [{"id":1,"title":"弟弟时刻","cover":null},{"id":2,"title":"弟弟心声","cover":null},{"id":3,"title":"弟弟杂谈","cover":null}]
     */

    private int code;
    private boolean error;
    private String message;
    private List<SubSection> data;

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

    public List<SubSection> getData() {
        return data;
    }

    public void setData(List<SubSection> data) {
        this.data = data;
    }
}
