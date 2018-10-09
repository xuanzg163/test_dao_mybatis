package com.test.po;

/**
 * User 实体
 */
public class User {

    private Integer id;
    private String userName;
    private String userPwd;
    private String realName;
    private String nation;
    private Integer cardId;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", realName='" + realName + '\'' +
                ", nation='" + nation + '\'' +
                ", cardId=" + cardId +
                '}';
    }

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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getCardID() {
        return cardId;
    }

    public void setCardID(Integer cardID) {
        this.cardId = cardID;
    }
}
