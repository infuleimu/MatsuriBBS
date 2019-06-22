package com.example.matsuribbsandroid.entity;

import java.sql.Timestamp;


public class User {


    private Integer id;
    private String userName;


    private String password;


    private String sex;


    private String avatar;


    private String email;


    private String phone;


    private Timestamp regDate = new Timestamp((new java.util.Date()).getTime());


    private Integer admin = 0;


    public Integer getId() {


        return id;


    }


    public void setId(Integer id) {


        this.id = id;


    }


    public String getUserName() {


        return userName;


    }


    public void setUserName(String userName) {


        this.userName = userName;


    }


    public String getPassword() {


        return password;


    }


    public void setPassword(String password) {


        this.password = password;


    }


    public String getSex() {


        return sex;


    }


    public void setSex(String sex) {


        this.sex = sex;


    }


    public String getAvatar() {


        return avatar;


    }


    public void setAvatar(String avatar) {


        this.avatar = avatar;


    }


    public String getEmail() {


        return email;


    }


    public void setEmail(String email) {


        this.email = email;


    }


    public String getPhone() {


        return phone;


    }


    public void setPhone(String phone) {


        this.phone = phone;


    }


    public Timestamp getRegDate() {


        return regDate;


    }


    public void setRegDate(Timestamp regDate) {


        this.regDate = regDate;


    }


    public Integer getAdmin() {


        return admin;


    }


    public void setAdmin(Integer admin) {


        this.admin = admin;


    }


}