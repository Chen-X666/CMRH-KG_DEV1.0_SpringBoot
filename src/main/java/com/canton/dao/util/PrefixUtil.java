package com.canton.dao.util;

import org.dom4j.Element;

/**
 * @Auther ChenX
 * @Date 2020.4.3
 * 为sparql查询定义prefix
 * 用于Timeline检索
 **/
public class PrefixUtil {
    public String setPrefix(String keyword)

    {
        Element root = ConfigurationUtil.getConfigurationRootElement("ontology-properties.xml");

        String rootURI = root.elementText("Root_Ontology_URI");

        String prefix = "<" + rootURI + "#" + keyword + ">" ;

        return  prefix;

    }
    public void getPrefix()
    {

    }

}
