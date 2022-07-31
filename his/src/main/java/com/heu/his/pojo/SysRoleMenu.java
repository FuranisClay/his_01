package com.heu.his.pojo;


public class SysRoleMenu {

  private long roleId;
  private long menuId;

  @Override
  public String toString() {
    return "SysRoleMenu{" +
            "roleId=" + roleId +
            ", menuId=" + menuId +
            '}';
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }

}
