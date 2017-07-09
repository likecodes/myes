package com.uxunchina.changsha.common.aut.pojo.po;

public class OperatorPo {
    /**
     * 操作员编号
     */
    private String operatorId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 中文名
     */
    private String usernameCn;

    /**
     * 用户密码
     */
    private String userPassword;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCn() {
        return usernameCn;
    }

    public void setUsernameCn(String usernameCn) {
        this.usernameCn = usernameCn;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operatorId=").append(operatorId);
        sb.append(", username=").append(username);
        sb.append(", usernameCn=").append(usernameCn);
        sb.append(", userPassword=").append(userPassword);
        sb.append("]");
        return sb.toString();
    }
}