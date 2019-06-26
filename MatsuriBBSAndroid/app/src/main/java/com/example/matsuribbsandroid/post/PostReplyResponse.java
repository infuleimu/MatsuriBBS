package com.example.matsuribbsandroid.post;

import com.example.matsuribbsandroid.entity.Reply;

import java.util.List;

public class PostReplyResponse {

    /**
     * code : 200
     * error : false
     * message : 成功
     * data : {"total":7,"pid":1,"page":1,"list":[{"id":1,"content":"傻逼楼主,nmsl","replyDate":"2019-06-10T16:00:43.000+0000","likeNum":0,"author":{"id":2,"userName":"1702040031","admin":0},"subReplyNum":4},{"id":2,"content":"你说你妈呢","replyDate":"2019-06-10T16:02:43.000+0000","likeNum":0,"author":{"id":1,"userName":"admin","admin":1},"subReplyNum":4},{"id":3,"content":"看戏看戏","replyDate":"2019-06-10T16:19:36.000+0000","likeNum":0,"author":{"id":3,"userName":"迪克","admin":1},"subReplyNum":0},{"id":4,"content":"wcnm","replyDate":"2019-06-10T20:20:53.000+0000","likeNum":0,"author":{"id":2,"userName":"1702040031","admin":0},"subReplyNum":0},{"id":6,"content":"灌水测试02","replyDate":"2019-06-11T16:42:50.000+0000","likeNum":0,"author":{"id":3,"userName":"迪克","admin":1},"subReplyNum":0},{"id":7,"content":"灌水测试03","replyDate":"2019-06-11T16:44:17.000+0000","likeNum":0,"author":{"id":3,"userName":"迪克","admin":1},"subReplyNum":0},{"id":10,"content":"回复测试01","replyDate":"2019-06-18T13:52:35.000+0000","likeNum":0,"author":{"id":1,"userName":"admin","admin":1},"subReplyNum":0}]}
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
         * total : 7
         * pid : 1
         * page : 1
         * list : [{"id":1,"content":"傻逼楼主,nmsl","replyDate":"2019-06-10T16:00:43.000+0000","likeNum":0,"author":{"id":2,"userName":"1702040031","admin":0},"subReplyNum":4},{"id":2,"content":"你说你妈呢","replyDate":"2019-06-10T16:02:43.000+0000","likeNum":0,"author":{"id":1,"userName":"admin","admin":1},"subReplyNum":4},{"id":3,"content":"看戏看戏","replyDate":"2019-06-10T16:19:36.000+0000","likeNum":0,"author":{"id":3,"userName":"迪克","admin":1},"subReplyNum":0},{"id":4,"content":"wcnm","replyDate":"2019-06-10T20:20:53.000+0000","likeNum":0,"author":{"id":2,"userName":"1702040031","admin":0},"subReplyNum":0},{"id":6,"content":"灌水测试02","replyDate":"2019-06-11T16:42:50.000+0000","likeNum":0,"author":{"id":3,"userName":"迪克","admin":1},"subReplyNum":0},{"id":7,"content":"灌水测试03","replyDate":"2019-06-11T16:44:17.000+0000","likeNum":0,"author":{"id":3,"userName":"迪克","admin":1},"subReplyNum":0},{"id":10,"content":"回复测试01","replyDate":"2019-06-18T13:52:35.000+0000","likeNum":0,"author":{"id":1,"userName":"admin","admin":1},"subReplyNum":0}]
         */

        private int total;
        private int pid;
        private int page;
        private List<Reply> list;

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

        public List<Reply> getList() {
            return list;
        }

        public void setList(List<Reply> list) {
            this.list = list;
        }
    }
}
