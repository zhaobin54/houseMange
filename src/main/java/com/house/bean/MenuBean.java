package com.house.bean;

import java.util.List;

import com.house.model.Function;

public class MenuBean {

	private String menuid;

	private String icon;

	private String menuname;

	private List<Function> menus;

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public List<Function> getMenus() {
		return menus;
	}

	public void setMenus(List<Function> menus) {
		this.menus = menus;
	}

}
