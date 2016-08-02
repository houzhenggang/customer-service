package com.hshc.kfpub.vo;

import com.hshc.kfpub.base.BaseVO;

/**
 * TODO
 *
 * @author 钟林俊
 * @version V1.0 2016-08-01 14:34
 */
public class MenuVo extends BaseVO {

    // 菜单类型，0菜单组，1菜单
    private String menuType;
    // 菜单名称
    private String menuName;
    // 菜单URL
    private String menuUrl;
    // 菜单图标路径
    private String menuIcon;

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
}
