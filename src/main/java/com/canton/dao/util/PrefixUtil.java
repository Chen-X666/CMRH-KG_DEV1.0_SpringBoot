package com.canton.dao.util;

import org.dom4j.Element;

import java.util.Iterator;

/**
 * @Auther ChenX
 * @Date 2020.4.3
 * 为sparql查询定义prefix
 * 用于Timeline检索
 **/
public class PrefixUtil {


    public String setPrefix(String url,String keyword)

    {
        Element root = ConfigurationUtil.getConfigurationRootElement("ontology-properties.xml");

        String URL = root.elementText(url);

        String prefix = "<" + URL + "#" + keyword + ">" ;
        return  prefix;


    }

    public void getPrefix()
    {


    }

}
