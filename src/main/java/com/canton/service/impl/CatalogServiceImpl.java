package com.canton.service.impl;

import com.canton.model.catalog.CatalogClassNode;
import com.canton.model.catalog.CatalogInstanceNode;
import com.canton.model.ontology.OntologyClass;
import com.canton.model.ontology.OntologyInstance;
import com.canton.service.CatalogService;
import com.canton.utils.JsonUtil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 本体目录的Service类。
 *
 * @author Rosahen
 * @version 1.0
 */

@SuppressWarnings("rawtypes")
@Service
public class CatalogServiceImpl extends BaseService implements CatalogService {

    @Override
    public String getNodeChildren(String nodeName) {
        // TODO Auto-generated method stub

        //将类节点名称封装成ontologyClass对象
        OntologyClass ontologyClass = new OntologyClass();

        //设置类名
        ontologyClass.setLocalName(nodeName);

        //调用本体解析器的方法获取子类集合
        Collection<OntologyClass> subClasses = getOntologyResolver().getSubClasses(ontologyClass);

        //创建类节点对象集合
        Collection<CatalogClassNode> nodes = new ArrayList<CatalogClassNode>();

        Iterator<OntologyClass> iter = null;

        if(subClasses!=null) iter = subClasses.iterator();

        //遍历子类集合
        while(iter!=null&&iter.hasNext()) {

            OntologyClass aClass = iter.next();

            //创建类节点对象
            CatalogClassNode node = new CatalogClassNode(aClass.getLocalName());

            //如果存在子类,那么就该节点属于父节点
            if(aClass.isHasSubClass()) node.setIsParent("true");

            //将该节点添加到类节点对象集合中
            nodes.add(node);

        }

        //调用json工具类的方法，将对象转换成json字符串
        String result = JsonUtil.formatAsJson(nodes);

        return result;
    }

    @Override
    public String getNodeContent(String nodeName) {
        // TODO Auto-generated method stub

        //将类节点名称封装成ontologyClass对象
        OntologyClass ontologyClass = new OntologyClass();

        //设置类名
        ontologyClass.setLocalName(nodeName);

        //调用本体解析器的方法获取实例集合
        Collection<OntologyInstance> instances = getOntologyResolver().getInstances(ontologyClass);

        //创建实例节点对象集合
        Collection<CatalogInstanceNode> nodes = new ArrayList<CatalogInstanceNode>();

        Iterator<OntologyInstance> iter = null;

        if(instances!=null) iter = instances.iterator();

        //遍历实例集合
        while(iter!=null&&iter.hasNext()) {

            OntologyInstance instance = iter.next();

            //为该实例创建一个实例节点对象
            CatalogInstanceNode node = new CatalogInstanceNode(instance.getLocalName());

            //添加到实例节点对象集合中
            nodes.add(node);
        }

        //调用json工具类的方法，将对象转换成json字符串
        String result = JsonUtil.formatAsJson(nodes);

        return result;
    }

    @Override
    public String getTopClassNodes() {
        // TODO Auto-generated method stub

        //调用本体解析器的方法获取顶层类集合
        Collection<OntologyClass> classes = getOntologyResolver().getTopClasses();
  System.out.println("classes"+classes);
        //创建类节点对象集合
        Collection<CatalogClassNode> nodes = new ArrayList<CatalogClassNode>();

        Iterator<OntologyClass> iter = null;

        if(classes!=null) iter = classes.iterator();

        //遍历顶层类集合
        while(iter!=null&&iter.hasNext()) {

            OntologyClass aClass = iter.next();

            //创建类节点对象
            CatalogClassNode node = new CatalogClassNode(aClass.getLocalName());

            //如果存在子类,那么该节点就属于父节点
            if(aClass.isHasSubClass()) node.setIsParent("true");

            //将该节点添加到类节点对象集合中
            nodes.add(node);

        }

        //调用json工具类的方法，将对象转换成json字符串
        String result = JsonUtil.formatAsJson(nodes);

        return result;
    }


}
