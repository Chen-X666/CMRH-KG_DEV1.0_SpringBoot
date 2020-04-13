package com.canton.model.data;

/**
 * Ehcarts力向图的节点对象。
 * 
 * @author Rosahen 
 * @version 1.0
 */
public class EchartsNode {

	/**
	 * 节点的名称。也是节点的主键。
	 */
	private String name;
	
	/**
	 * 节点的数据项值。
	 */
	private String value = "40";
	
	/**
	 * 数据项所在类目的 index。
	 */
	private String category = "1";
	
	/**
	 * 	该类目节点标记的图形。
		ECharts 提供的标记类型包括 'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow'
		也可以通过 'image://url' 设置为图片，其中 url 为图片的链接，或者 dataURI。
		可以通过 'path://' 将图标设置为任意的矢量路径。这种方式相比于使用图片的方式，不用担心因为缩放而产生锯齿或模糊，而且可以设置为任意颜色。路径图形会自适应调整为合适的大小。
	 */
	private String symbol;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EchartsNode other = (EchartsNode) obj;
		
		if(getName().equals(other.getName())) return true;
		
		else return false;
	}

	
}
