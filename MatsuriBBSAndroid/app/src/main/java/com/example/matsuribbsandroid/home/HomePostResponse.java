package com.example.matsuribbsandroid.home;

import com.example.matsuribbsandroid.entity.Post;

import java.util.List;

public class HomePostResponse {


    /**
     * code : 200
     * error : false
     * message : 成功
     * data : {"total":5,"page":1,"list":[{"id":1,"title":"嘻嘻哈哈","content":"喂喂喂","postDate":"2019-06-04T00:00:00.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"迪克","admin":0}},{"id":5,"title":"发帖测试","content":"发帖测试","postDate":"2019-06-18T07:30:18.000+0000","type":2,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":1,"author":{"userName":"admin","admin":0}},{"id":4,"title":"测试测试","content":"测试测试","postDate":"2019-06-11T19:24:34.000+0000","type":1,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"admin","admin":0}},{"id":2,"title":"test","content":"nmsl","postDate":"2019-06-11T19:18:39.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"admin","admin":0}},{"id":3,"title":"测试","content":"测试","postDate":"2019-06-11T18:56:29.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"admin","admin":0}}]}
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
         * total : 5
         * page : 1
         * list : [{"id":1,"title":"嘻嘻哈哈","content":"喂喂喂","postDate":"2019-06-04T00:00:00.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"迪克","admin":0}},{"id":5,"title":"发帖测试","content":"发帖测试","postDate":"2019-06-18T07:30:18.000+0000","type":2,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":1,"author":{"userName":"admin","admin":0}},{"id":4,"title":"测试测试","content":"测试测试","postDate":"2019-06-11T19:24:34.000+0000","type":1,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"admin","admin":0}},{"id":2,"title":"test","content":"nmsl","postDate":"2019-06-11T19:18:39.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"admin","admin":0}},{"id":3,"title":"测试","content":"测试","postDate":"2019-06-11T18:56:29.000+0000","type":0,"replyNum":0,"viewNum":0,"likeNum":0,"isTop":0,"author":{"userName":"admin","admin":0}}]
         */

        private int total;
        private int page;
        private List<Post> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public List<Post> getList() {
            return list;
        }

        public void setList(List<Post> list) {
            this.list = list;
        }
    }
}
