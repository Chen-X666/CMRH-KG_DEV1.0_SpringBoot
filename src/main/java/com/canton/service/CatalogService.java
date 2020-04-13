package com.canton.service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 本体目录的Service接口。提供获取某节点的子节点的方法和某节点的实例的方法。
 *
 * @author Rosahen
 * @version 1.0
 */
public  interface  CatalogService {

    /**
     * 获取某节点的子节点的方法。
     *
     * @param nodeName 某节点的名称。
     * @return 某节点的子节点集合的json格式字符串。
     * @throws JsonProcessingException
     */
    String getNodeChildren(String nodeName);

    /**
     * 获取某节点的实例的方法。
     *
     * @param nodeName 某节点的名称。
     * @return 某节点的实例集合的json格式字符串。
     */
    String getNodeContent(String nodeName);

    /**
     * 获取本体顶层类的节点方法。
     *
     * @return 本体顶层类节点集合的json格式字符串。
     */
    String getTopClassNodes();
}
