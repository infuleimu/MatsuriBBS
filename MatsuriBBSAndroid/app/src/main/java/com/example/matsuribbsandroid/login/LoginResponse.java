package com.example.matsuribbsandroid.login;


import com.example.matsuribbsandroid.entity.User;

public class LoginResponse {

    /**
     * code : 200
     * <p>
     * <p>
     * <p>
     * error : false
     * <p>
     * <p>
     * <p>
     * message : 成功
     * <p>
     * <p>
     * <p>
     * data : {"user":{"id":1,"userName":"admin","sex":"女","email":"100000@qq.com","phone":"18078060977","admin":1},"token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJEaWNrRHJhZ29uIiwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTU2MTEyMTA0MH0.ZcMwBfZErmMNyqCB22qFk7ZoQqc2eGN-3PXAvsaYzpA"}
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
         * user : {"id":1,"userName":"admin","sex":"女","email":"100000@qq.com","phone":"18078060977","admin":1}
         * <p>
         * <p>
         * <p>
         * token : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJBUFAiLCJpc3MiOiJEaWNrRHJhZ29uIiwidXNlck5hbWUiOiJhZG1pbiIsImlhdCI6MTU2MTEyMTA0MH0.ZcMwBfZErmMNyqCB22qFk7ZoQqc2eGN-3PXAvsaYzpA
         */


        private User user;


        private String token;


        public User getUser() {


            return user;


        }


        public void setUser(User user) {


            this.user = user;


        }


        public String getToken() {


            return token;


        }


        public void setToken(String token) {


            this.token = token;


        }


    }


}