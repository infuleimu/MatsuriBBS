package com.example.matsuribbsandroid.post;

import com.example.matsuribbsandroid.entity.SubReply;

import java.util.List;

public class MoreReplyResponse {


    /**
     * code : 200
     * error : false
     * message : 成功
     * data : {"total":4,"pid":1,"page":1,"list":[{"id":4,"content":"¿","replyDate":"2019-06-09T23:49:12.000+0000","likeNum":0,"author":{"id":4,"userName":"1702040031","admin":0}},{"id":1,"content":"吃瓜","replyDate":"2019-06-10T19:47:02.000+0000","likeNum":0,"author":{"id":1,"userName":"迪克","admin":0}},{"id":2,"content":"sb","replyDate":"2019-06-10T21:04:33.000+0000","likeNum":0,"author":{"id":2,"userName":"1702040031","admin":0}},{"id":3,"content":"???","replyDate":"2019-06-10T23:48:54.000+0000","likeNum":0,"author":{"id":3,"userName":"admin","admin":0}}]}
     */

    private int code;
    private boolean error;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 4
         * pid : 1
         * page : 1
         * list : [{"id":4,"content":"¿","replyDate":"2019-06-09T23:49:12.000+0000","likeNum":0,"author":{"id":4,"userName":"1702040031","admin":0}},{"id":1,"content":"吃瓜","replyDate":"2019-06-10T19:47:02.000+0000","likeNum":0,"author":{"id":1,"userName":"迪克","admin":0}},{"id":2,"content":"sb","replyDate":"2019-06-10T21:04:33.000+0000","likeNum":0,"author":{"id":2,"userName":"1702040031","admin":0}},{"id":3,"content":"???","replyDate":"2019-06-10T23:48:54.000+0000","likeNum":0,"author":{"id":3,"userName":"admin","admin":0}}]
         */

        private int total;
        private int pid;
        private int page;
        private List<SubReply> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<SubReply> getList() {
            return list;
        }

        public void setList(List<SubReply> list) {
            this.list = list;
        }

    }
}
