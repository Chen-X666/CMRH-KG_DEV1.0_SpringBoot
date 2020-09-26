package com.canton.service.impl;

import com.canton.dao.entity.AllEvent;
import com.canton.dao.entity.Reminiscence;
import com.canton.model.ontology.Statement;
import com.canton.service.EventReminiscenceService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther ChenX
 * @Date 2020.4.15
 **/
@Service
public class EventReminiscenceServiceImpl extends BaseService implements EventReminiscenceService {




    @Override
    public List<AllEvent> getAllEvent() {
        String event=  "<http://www.owl-ontologies.com/Recall.owl#事件回溯>";
        String type = "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>";
        String node = "<http://www.owl-ontologies.com/Recall.owl#recall_node>";
        String time = "<http://www.owl-ontologies.com/Event.owl#开始时间>";
        String location = "<http://www.owl-ontologies.com/Event.owl#事件地点>";
        String rank = "<http://www.owl-ontologies.com/Time.owl#排序时间>";
        String sparqlStr =
                "SELECT DISTINCT   ?object ?time ?rank " +
                        "WHERE {" +
                        " ?event ?predicate "+event+"." +
                        "  ?subject "+type+" ?event." +
                        "  ?object "+node+" ?subject." +
                        "  ?object "+time+" ?time." +
                      //  "  ?object"+location+" ?location." +
                        "  ?time "+rank+" ?rank }" +
                        "  ORDER BY ?rank";


        Collection<Statement> statements = getOntologyResolver().query(sparqlStr);


        if (statements.size() > 0) {

            Iterator<Statement> iter = statements.iterator();
            List<AllEvent> list = new ArrayList<>();
            while (iter.hasNext()) {
                AllEvent allEvent = new AllEvent();
                Statement statement = iter.next();
                allEvent.setTitle(statement.getSubject());
                allEvent.setTime(statement.getPredicate());
                list.add(allEvent);
            }
            return list;
        }
        else
        {
            System.out.println("无检索allevent");
            return null;
        }
    }


    @Override
    public Reminiscence getChildEvent(String event) {
        String parentEvent=  "<http://www.owl-ontologies.com/Recall.owl#"+event+"_回溯>";
        String time =  "<http://www.owl-ontologies.com/Recall.owl#time>";
        String location =  "<http://www.owl-ontologies.com/Recall.owl#location>";
        String comment =  "<http://www.w3.org/2000/01/rdf-schema#comment>";

        String sparqlStr =
                "SELECT DISTINCT  ?childEvent ?time ?location " +
                        "WHERE {" +
                        "  ?subject ?predicate "+parentEvent+"." +
                        "  ?subject "+comment+" ?childEvent. " +
                        "  ?subject "+time+" ?time." +
                        "  ?subject "+location+" ?location}" +
                        "  ORDER BY ?subject";

        Collection<Statement> statements = getOntologyResolver().query(sparqlStr);


        if (statements.size() > 0) {

            return eventreminiscenceData(statements,event);

        }
        else
        {
            System.out.println("无检索event");
        }
         return null;
    }
    public static Reminiscence eventreminiscenceData(Collection<Statement> statements,String event)
    {
        Iterator<Statement> iter = statements.iterator();

        List<List> listtt = new ArrayList();
        while (iter.hasNext()) {
            List<List> listt = new ArrayList();
            Statement statement = iter.next();
            List list = new ArrayList();
            list.add(statement.getPredicate());
            list.add(statement.getObject());
            list.add(event);
            StringBuffer childEvent = new StringBuffer(statement.getSubject());
            for(int i=15;i<statement.getSubject().length();i+=16)
            {   childEvent = childEvent.insert(i,'\n');}
            list.add(childEvent);
            listt.add(list);
            listtt.add(listt);
        }
        Reminiscence reminiscence = new Reminiscence();
        reminiscence.setSeries(listtt);
        reminiscence.setCounties(Collections.singletonList(event));
        return reminiscence;
    }
    }


