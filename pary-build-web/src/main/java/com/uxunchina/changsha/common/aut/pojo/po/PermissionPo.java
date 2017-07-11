package com.uxunchina.changsha.common.aut.pojo.po;

public class PermissionPo {
    /**
     * 权限编号
     */
    private String permId;

    /**
     * 权限名字
     */
    private String permName;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 系统权限资源表
     */
    private String resouce;

    /**
     * 父权限编号
     */
    private String parentId;

    /**
     * 权限类型,1.菜单，2 按钮
     */
    private String permType;

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResouce() {
        return resouce;
    }

    public void setResouce(String resouce) {
        this.resouce = resouce;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPermType() {
        return permType;
    }

    public void setPermType(String permType) {
        this.permType = permType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permId=").append(permId);
        sb.append(", permName=").append(permName);
        sb.append(", description=").append(description);
        sb.append(", resouce=").append(resouce);
        sb.append(", parentId=").append(parentId);
        sb.append(", permType=").append(permType);
        sb.append("]");
        return sb.toString();
    }
}