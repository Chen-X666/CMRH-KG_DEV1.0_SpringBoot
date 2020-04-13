package com.canton.model.catalog;

import java.io.Serializable;

/**
 * 目录实例节点对象。
 * 
 * @author Rosahen 
 * @version 1.0 
 */
public class CatalogInstanceNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1563122300471436077L;

	/**
	 * 节点的名字。
	 */
	private String name;
	
	/**
	 * 节点的图标。
	 */
	private final String icon = "./icon/instanceIcon.gif";
	
	
	/**
	 * 目录实例节点的构造方法。
	 * 
	 * @param name 节点的名字。
	 */
	public CatalogInstanceNode(String name) {
		super();
		this.name = name;
	}
	
	
	public CatalogInstanceNode() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	
	
}
