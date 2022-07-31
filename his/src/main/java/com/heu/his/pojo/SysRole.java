package com.heu.his.pojo;


public class SysRole {

  private long roleId;
  private long roleParentId;
  private String roleName;
  private String delFlag;
  private java.sql.Timestamp createTime;
  private String remark;

  @Override
  public String toString() {
    return "SysRole{" +
            "roleId=" + roleId +
            ", roleParentId=" + roleParentId +
            ", roleName='" + roleName + '\'' +
            ", delFlag='" + delFlag + '\'' +
            ", createTime=" + createTime +
            ", remark='" + remark + '\'' +
            '}';
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public long getRoleParentId() {
    return roleParentId;
  }

  public void setRoleParentId(long roleParentId) {
    this.roleParentId = roleParentId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getDelFlag() {
    return delFlag;
  }

  public void setDelFlag(String delFlag) {
    this.delFlag = delFlag;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
