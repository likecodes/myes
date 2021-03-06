package com.uxunchina.changsha.common.aut.pojo.po;

public class UserRolePo {
    /**
     * 用户编号
     */
    private String operatorId;

    /**
     * 角色编号
     */
    private String roleId;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operatorId=").append(operatorId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}