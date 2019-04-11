package com.ryz2593.domain;

/**
 * @author ryz2593
 * @date 2019/4/11
 * @desc
 */
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userPass;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
