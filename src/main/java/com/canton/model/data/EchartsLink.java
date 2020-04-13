package com.canton.model.data;

/**
 * Echarts力向图的边对象。
 * 
 * @author Rosahen
 * @version 1.0
 */
public class EchartsLink {

	/**
	 * 边的起点。为EchartsNode对象的name属性。
	 */
	private String source;
	
	/**
	 * 边的终点。为EchartsNode对象的name属性。
	 */
	private String target;
	
	/**
	 * 边的数值。可以在力引导布局中用于映射到边的长度。
	 */
	private String value;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		
		return (source+target+value).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EchartsLink other = (EchartsLink) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
