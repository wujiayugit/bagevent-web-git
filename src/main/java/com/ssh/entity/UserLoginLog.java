package com.ssh.entity;

import java.util.Date;

public class UserLoginLog {
    private int loginId;
    private int userId;
    private Date loginTime;
    private int loginIp;

    public UserLoginLog() {
    }

    public UserLoginLog(int loginId, int userId, Date loginTime, int loginIp) {
        this.loginId = loginId;
        this.userId = userId;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public int getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(int loginIp) {
        this.loginIp = loginIp;
    }

    @Override
    public String toString() {
        return "UserLoginLog{" +
                "loginId=" + loginId +
                ", userId=" + userId +
                ", loginTime=" + loginTime +
                ", loginIp=" + loginIp +
                '}';
    }
}
