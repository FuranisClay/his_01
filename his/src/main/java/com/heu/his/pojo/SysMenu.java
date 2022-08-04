package com.heu.his.pojo;


import java.util.List;

public class SysMenu {

  private long menuId;
  private String menuName;
  private long parentId;
  private String url;
  private String visible;
  private String remark;

  private java.util.List<SysMenu> childMenu;//子集权限

  public List<SysMenu> getChildMenu() {
    return childMenu;
  }

  public void setChildMenu(List<SysMenu> childMenu) {
    this.childMenu = childMenu;
  }

  @Override
  public String toString() {
    return "SysMenu{" +
            "menuId=" + menuId +
            ", menuName='" + menuName + '\'' +
            ", parentId=" + parentId +
            ", url='" + url + '\'' +
            ", visible='" + visible + '\'' +
            ", remark='" + remark + '\'' +
            '}';
  }

  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }


  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public String getVisible() {
    return visible;
  }

  public void setVisible(String visible) {
    this.visible = visible;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
