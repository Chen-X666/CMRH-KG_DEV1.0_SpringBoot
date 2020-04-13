package com.canton.model.catalog;

import java.io.Serializable;

/**
 * 目录的类节点对象。
 * 
 * @author Rosahen 
 * @version 1.0
 */ 

public class CatalogClassNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5336960284430411305L;

	/**
	 * 节点的名字。
	 */
	private String name;
	
	/**
	 * 节点被展开时的图标。
	 */
	private final String iconOpen = "./icon/foldericon_alter.gif";
	
	/**
	 * 节点被收起时的图标。
	 */
	private final String iconClose = "./icon/unfoldericon_alter.gif";
	
	/**
	 * 节点默认显示的图标。
	 */
	private final String icon = "./icon/unfoldericon_alter.gif";
	
	/**
	 * 标识该节点是否有子节点。
	 */
	private String isParent = "false";
	
	
	/**
	 * 目录类节点对象构造方法。
	 * @param name 该节点的名字。
	 * @param isParent 标识该节点是否有子节点。
	 */
	public CatalogClassNode(String name, String isParent) {
		super();
		this.name = name;
		this.isParent = isParent;
	}
	
	/**
	 * 目录类节点对象构造方法。
	 * @param name 该节点的名字。
	 */
	public CatalogClassNode(String name) {
		super();
		this.name = name;
	}
	
	public CatalogClassNode() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getIconOpen() {
		return iconOpen;
	}


	public String getIconClose() {
		return iconClose;
	}


	public String getIcon() {
		return icon;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

}
