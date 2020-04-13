package com.canton.controller;

import com.canton.dao.util.JenaUtil;
import com.canton.dao.util.ConfigurationUtil;
import com.canton.dao.util.DefaultOntModel;
import com.canton.dao.util.LuceneUntil;
import org.apache.jena.ontology.OntModel;
import org.dom4j.Element;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;

/**
 * 项目生命周期监听器。在此监听器对项目做一些初始化工作。
 *
 * @author Rosahen,ChenX
 * @version 2.0
 */
@WebListener
public class LifeCycleListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public LifeCycleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */

	public void contextInitialized(ServletContextEvent sce) {
		/**
		 * 构建本体模型
		 */
		System.out.println("开始初始化本体模型数据...");
		// TODO Auto-generated method stub
       //配置文件根路径
		Element root = ConfigurationUtil.getConfigurationRootElement("ontology-properties.xml");
		//获取默认模型的URI
       String defaultModelURI = root.element("Named_Graph").element("Default_Graph").elementText("URI");
      // System.out.println("将模型添加到Dataset...");
        OntModel defaultOntModel = JenaUtil.addNamedModel(defaultModelURI);
       DefaultOntModel.getInstance().setOntModel(defaultOntModel);
      System.out.println("初始化本体模型数据完成");

		/**
		 * 构建全文索引
		 */
		//索引保存到的路径
		System.out.println("开始初始化全文索引...");
		File directory = new File("src/main/resources");
		String path = null;
		try {
			path = directory.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String indexDir = path+"/lucene";
		//需要索引的文件数据存放的目录
		String dataDir = path+"/book";
		LuceneUntil indexer = null;
		int indexedNum = 0;
		//记录索引开始时间
		long startTime = System.currentTimeMillis();
		try {
			// 开始构建索引
			indexer = new LuceneUntil(indexDir);
			indexedNum = indexer.indexAll(dataDir);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != indexer) {
					indexer.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//记录索引结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("索引耗时" + (endTime - startTime) + "毫秒");
		System.out.println("共索引了" + indexedNum + "个文件");

	}

	}
