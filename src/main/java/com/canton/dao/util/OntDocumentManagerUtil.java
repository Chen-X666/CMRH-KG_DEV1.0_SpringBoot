package com.canton.dao.util;

import org.apache.jena.ontology.OntDocumentManager;
import org.dom4j.Element;

import java.util.Iterator;

/**
 * 本体文档管理器工具。
 * 
 * @author Rosahen
 * @version 1.0
 */
public class OntDocumentManagerUtil {

	private OntDocumentManagerUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 批量添加本体文件URI和本地路径之间的映射。
	 * 
	 * @param dm 本体文档管理器对象。
	 */
	public static void addAltEntries(OntDocumentManager dm){

		String applicationPath = OntDocumentManagerUtil.class.getResource("/").getPath();
		
		//获取本体配置文件的根元素
		Element root = ConfigurationUtil.getConfigurationRootElement("ontology-properties.xml");
		
		//获取名为Ontology_Files的元素
		Element ontologyFiles = root.element("Ontology_Files");
		
		//获取Ontology_Files的子元素Ontology_File
		@SuppressWarnings("rawtypes")
		Iterator iter = ontologyFiles.elementIterator("Ontology_File");
		
		while(iter.hasNext()) {
			
			Element element = (Element) iter.next();
			System.out.println("本体文件加载中:"+element.elementText("URI"));
			//获取Ontology_File元素的URI值和File_Path值,并添加映射
			dm.addAltEntry(element.elementText("URI"), "file:"+applicationPath+element.elementText("File_Path"));
			
		}
	}
}
